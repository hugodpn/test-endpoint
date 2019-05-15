/**
 * Example of dynamic job listener created by endpoint configuration
 *
 * Created by egonzalez on 15/08/17.
 */
listeners.listenerForExportRecords = {
    label: 'Listener for Export records',
    type: 'job',
    options: {
        jobType: 'exportRecords',
        event: 'finished'
    },
    callback: function(event) {
        sys.logs.info('Entering to JOB listener handler');
        sys.logs.info('Event: '+JSON.stringify(event));
    }
};