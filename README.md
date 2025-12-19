## Steps to Reproduce

#### 1. Create new server (CommandBox 6.2.1+00830)
    server start name=Lucee7LogTest directory="C:\work\lucee7logtest" cfEngine=lucee@7.0.0.395
    
#### 2. Copy custom jar into WEB-INF\lib
    C:\...\lucee-7.0.0.395\WEB-INF\lib\com.mycompany.utils.paymentprocessor.jar

#### 3. Create "payment" logger in Admin / .CFConfig.json

    "payment":{
            "appender":"resource",
            "appenderArguments":"path:{lucee-config}/logs/payment.log",
            "layout":"classic",
            "level":"error"
     },

#### 4. Start server
    server start Lucee7LogTest

NB: Also enabled settings 

	set LUCEE_LOGGING_FORCE_APPENDER=console
	set LUCEE_LOGGING_FORCE_LEVEL=debug
	set LUCEE_INSPECT_TEMPLATE="always"


#### Expected result: 
Custom class and CFLog write to "...\lucee-7.0.0.395\WEB-INF\lucee-server\context\logs\payment.log"
 
#### Actual result:
- CFLog writes to "..\context\logs\payment.log"
- Custom class doesn't write to any log file(s)
