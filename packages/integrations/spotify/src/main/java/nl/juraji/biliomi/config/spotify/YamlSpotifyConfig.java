package nl.juraji.biliomi.config.spotify;

/**
 * Created by Juraji on 22-10-2017.
 * Biliomi
 */
public class YamlSpotifyConfig {
  private String consumerKey;
  private String consumerSecret;

  public String getConsumerKey() {
    return consumerKey;
  }

  public void setConsumerKey(String consumerKey) {
    this.consumerKey = consumerKey;
  }

  public String getConsumerSecret() {
    return consumerSecret;
  }

  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
  }
}
