#step 1

keytool -genkey -alias <alias_name> -keyalg RSA -keystore keystore.jks -storepass <password>

#step 2

keytool -export -alias <alias_name> -keystore keystore.jks -rfc -file <certificate_name>.cert

#step 3

keytool -import -alias <alias_name> -file <certificate_name>.cert -keystore truststore.jks -storepass <password>