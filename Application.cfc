component {

    this.name = hash( "Lucee7LogTest_"& getCurrentTemplatePath() );
    this.applicationTimeout = CreateTimeSpan(0,0,10,0);

    /* Also tried using App settings 
    this.logs["payment"] = {
        appender: "resource",
        appenderArguments: { resource: "{lucee-config}/logs/payment.log" },
        layout: "classic",
        level: "debug"
    };
    */

    function onApplicationStart() {
        writeLog(text="Invoked onApplicationStart", type="info");
    }

    function onRequestStart( string targetPage ) {
        writeLog(text="Invoked onRequestStart: #targetPage#", type="info");
    }
    
 }

 