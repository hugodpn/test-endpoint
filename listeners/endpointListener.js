/**
 * Example of dynamic endpoint listener created by endpoint configuration
 *
 * Created by egonzalez on 14/08/17.
 */
listeners.listenerForSample = {
    label: 'Listener for Sample Complex endpoint',
    type: 'endpoint',
    options: {
        endpoint: endpoint.name,
        event: 'inboundEvent'
    },
    callback: function(event) {
        sys.logs.info('Entering to ENDPOINT listener handler');
        sys.logs.info('Event: '+JSON.stringify(event));
    }
};