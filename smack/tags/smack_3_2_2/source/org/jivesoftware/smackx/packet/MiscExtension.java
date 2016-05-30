package org.jivesoftware.smackx.packet;

import org.jivesoftware.smack.packet.PacketExtension;
import org.jivesoftware.smack.provider.PacketExtensionProvider;
import org.xmlpull.v1.XmlPullParser;

/**
 * A packet extension used to advertise the unique ids of the 
 * running conference.
 *
 * @author Martin Sebastian
 */
public class MiscExtension implements PacketExtension
{
    /**
     * XML element name of this packets extension.
     */
    public static final String ELEMENT_NAME = "data";

    /**
     * The namespace that qualifies the XML element of an extension.
     */
    public static final String NAMESPACE = "urn:xmpp:comcast:info";

    private String event;
    private String traceId;
    private String nodeId;
    private String cNodeId;
    private String uNodeId;

    /*
     * (non-Javadoc)
     * 
     * @see org.jivesoftware.smack.packet.PacketExtension#getElementName()
     */
    public String getElementName() {
        return ELEMENT_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jivesoftware.smack.packet.PacketExtension#getNamespace()
     */
    public String getNamespace() {
        return NAMESPACE;
    }

    /**
     * Sets the event type in Jitsi Meet conference.
     *
     * @param event value to set.
     */
    public void setEvent(String event)
    {
        this.event = event;
    }

    /**
     * Returns the name of event type of conference.
     */
    public String getEvent()
    {
        return event;
    }

    /**
     * Sets the traceId in Jitsi Meet conference.
     *
     * @param traceId value to set.
     */
    public void setTraceId(String traceId)
    {
        this.traceId = traceId;
    }

    /**
     * Returns the traceId value of conference.
     */
    public String getTraceId()
    {
        return traceId;
    }

    /**
     * Sets the nodeId in Jitsi Meet conference.
     *
     * @param nodeId value to set.
     */
    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }

    /**
     * Returns the nodeId value of conference.
     */
    public String getNodeId()
    {
        return nodeId;
    }

    /**
     * Sets the cNodeId in Jitsi Meet conference.
     *
     * @param cNodeId value to set.
     */
    public void setCNodeId(String cNodeId)
    {
        this.cNodeId = cNodeId;
    }

    /**
     * Returns the cNodeId value of conference.
     */
    public String getCNodeId()
    {
        return cNodeId;
    }

    /**
     * Sets the uNodeId in Jitsi Meet conference.
     *
     * @param uNodeId value to set.
     */
    public void setUNodeId(String uNodeId)
    {
        this.uNodeId = uNodeId;
    }

    /**
     * Returns the uNodeId value of conference.
     */
    public String getUNodeId()
    {
        return uNodeId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jivesoftware.smack.packet.PacketExtension#toXML()
     */
    public String toXML() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<").append(getElementName());
        sb.append(" xmlns='").append(getNamespace()).append("' ");

        if(getEvent() != null && !getEvent().equals(""))
            sb.append(" event='").append(getEvent()).append("' ");

        if(getTraceId() != null && !getTraceId().equals(""))
            sb.append(" traceid='").append(getTraceId()).append("' ");

        if(getNodeId() != null && !getNodeId().equals(""))
            sb.append(" nodeid='").append(getNodeId()).append("' ");

        if(getCNodeId() != null && !getCNodeId().equals(""))
            sb.append(" cnodeid='").append(getCNodeId()).append("' ");

        if(getUNodeId() != null && !getUNodeId().equals(""))
            sb.append(" unodeid='").append(getUNodeId()).append("' ");

        sb.append("/>");
        return sb.toString();
    }

    public static class Provider implements PacketExtensionProvider {

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.jivesoftware.smack.provider.PacketExtensionProvider#parseExtension
         * (org.xmlpull.v1.XmlPullParser)
         */
        public PacketExtension parseExtension(XmlPullParser arg0)
                throws Exception {
            return new MiscExtension();
        }
    }
}
