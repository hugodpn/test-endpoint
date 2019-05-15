/**
 * Example of dynamic user listener created by endpoint configuration
 *
 * Created by egonzalez on 15/08/17.
 */
listeners.listenerForUserChanges = {
    label: 'Listener for user changes',
    type: 'user',
    options: {
        event: 'userChanged'
    },
    callback: function(event, user) {
        sys.logs.info('Entering to USER listener handler');
        sys.logs.info('Event: '+JSON.stringify(event));
        sys.logs.info('User: '+JSON.stringify(user));
    }
};