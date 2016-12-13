@GrabResolver(name='httpclient', root='https://repo1.maven.org/maven2/')
@Grab('org.apache.httpcomponents:httpclient:4.5.2')

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClients;

def call(String restURL){

  CloseableHttpClient httpclient = HttpClients.createDefault();
  HttpGet httpget = new HttpGet(restURL);
  CloseableHttpResponse response = httpclient.execute(httpget);
  try {
    def line = response.getStatusLine()
    return line.toString()
  } finally {
    response.close();
  }
  return "NO"
}


