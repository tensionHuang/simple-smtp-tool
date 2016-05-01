# simple-smtp-tool

Simple mail-sending check tool.
You can change the config file and run immediately without buiding zip again.

Config file is named 'system.properties'.

# SMTP mail config
Mailtrap is recommended for SMTP mail-sending test
https://mailtrap.io/

* smtp.mail.timeout=30000
* smtp.mail.host=mailtrap.io
* smtp.mail.port=2525
* smtp.mail.isSSL=false
* smtp.mail.username=
* smtp.mail.password=
* smtp.mail.sender.address=tensionHuang@test.com
* smtp.mail.recipient.address=9489bb1a4f-8255b6@inbox.mailtrap.io

# Build a distribution that run it directly by script(bat/sh)
1. Execute Gradle task to generate runnable distribution(zip file). EX: $gradle distZip
2. Find the simple-smtp-tool-1.0.zip under 'build/distribution' folder
3. Unzip it and run the script under 'bin' folder
4. log file is generated under 'bin' folder
