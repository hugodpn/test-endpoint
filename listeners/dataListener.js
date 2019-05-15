/**
 * Example of dynamic data listener created by endpoint configuration
 *
 * Created by egonzalez on 11/08/17.
 */
var getEntity = function(){
    return 'companies';
};

listeners.listenerForCompaniesChanges = {
    label: 'Listener for Companies changes',
    type: 'data',
    options: {
        executeInBackground: true,
        entity: getEntity(),
        events: [
            { type: 'recordChanged' },
            { type: 'recordDeleted' }
        ]
    },
    callback: function(event, record, oldRecord) {
        sys.logs.info('Entering to listener handler');
        sys.logs.info('Event: '+JSON.stringify(event));
        sys.logs.info('Record: '+JSON.stringify(record));
        sys.logs.info('Old record: '+(oldRecord ? JSON.stringify(oldRecord) : ''));
    }
};
