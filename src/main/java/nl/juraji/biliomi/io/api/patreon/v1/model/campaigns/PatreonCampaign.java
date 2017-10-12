package nl.juraji.biliomi.io.api.patreon.v1.model.campaigns;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Juraji on 12-10-2017.
 * Biliomi
 */
@XmlRootElement(name = "PatreonCampaign")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatreonCampaign {

  @XmlElement(name = "id")
  private String id;

  @XmlElement(name = "attributes")
  private PatreonCampaignAttributes attributes;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PatreonCampaignAttributes getAttributes() {
    return attributes;
  }

  public void setAttributes(PatreonCampaignAttributes attributes) {
    this.attributes = attributes;
  }
}
