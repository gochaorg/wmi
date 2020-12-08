package xyz.cofe.win.wmi.stdcimv2;

import xyz.cofe.win.wmi.WmiObj;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface MSFT_NetTCPConnection extends WmiObj {
    public short getAggregationBehavior();

    public byte getAppliedSetting();

    /* property AvailableRequestedStates : array - not supported */

    public String getCaption();

    public short getCommunicationStatus();

    public java.util.Optional<java.time.OffsetDateTime> getCreationTime();

    public String getDescription();

    public short getDetailedStatus();

    public short getDirectionality();

    public String getElementName();

    public short getEnabledDefault();

    public short getEnabledState();

    public short getHealthState();

    public java.util.Optional<java.time.OffsetDateTime> getInstallDate();

    public String getInstanceID();

    public String getLocalAddress();

    public int getLocalPort();

    public String getName();

    /**
     * The connection offload state of the TCP connection.
     * <ul>
     * <li>InHost (0)
     * <li>Offloading (1)
     * <li>Offloaded (2)
     * <li>Uploading (3)
     * </ul>
     * @return offload state
     */
    public byte getOffloadState();

    public short getOperatingStatus();

    /* property OperationalStatus : array - not supported */

    public String getOtherEnabledState();

    public int getOwningProcess();

    public short getPrimaryStatus();

    public String getRemoteAddress();

    public int getRemotePort();

    public short getRequestedState();

    /**
     * The state of the TCP connection.
     *
     * <table>
     *     <tr>
     * <td>Value 	</td><td>Meaning</td>
     * </tr><tr>
     * <td>1 Closed
     * </td>	<td>Represents no connection state at all.</td>
     * </tr><tr>
     *
     * <td>2 Listen
     * 	</td><td>Waiting for a connection request from any remote TCP and port.</td>
     * </tr><tr>
     *
     * <td>3 SynSent
     * 	</td><td>Waiting for a matching connection request after having sent a connection request (SYN packet).</td>
     *
     * </tr><tr>
     *
     * <td>4 SynReceived
     * 	</td><td>Waiting for a confirming connection request acknowledgment after having both received and sent a connection request (SYN packet).
     *</td>
     * </tr><tr>
     *
     * <td>5 Established
     * 	</td><td>Represents an open connection, data received can be delivered to the user. This is the normal state for the data transfer phase of the TCP connection.
     *</td>
     *
     * </tr><tr>
     * <td>6 FinWait1
     * 	</td><td>Waiting for a connection termination request from the remote TCP, or an acknowledgment of the connection termination request previously sent.
     *</td>
     *
     * </tr><tr>
     * <td>7 FinWait2
     * 	</td><td>Waiting for a connection termination request from the remote TCP.
     *</td>
     *
     * </tr><tr>
     * <td>8 CloseWait
     * 	</td><td>Waiting for a connection termination request from the local user.
     *</td>

     * </tr><tr>
     * <td>9 Closing
     * 	</td><td>Waiting for a connection termination request acknowledgment from the remote TCP.
     *</td>

     * </tr><tr>
     * <td>10 LastAck
     * 	</td><td>Waiting for an acknowledgment of the connection termination request previously sent to the remote TCP.
     *</td>

     * </tr><tr>
     * <td>11 TimeWait
     * </td><td>Waiting for enough time to pass to be sure the remote TCP received the acknowledgment of its connection termination request.
     *
     * </tr><tr>
     * <td>12 DeleteTCB</td><td></td>
     * </tr>
     * </table>
     * @return The state of the TCP connection.
     */
    public byte getState();

    public String getStatus();

    /* property StatusDescriptions : array - not supported */

    public java.util.Optional<java.time.OffsetDateTime> getTimeOfLastStateChange();

    public short getTransitioningToState();

    public static void query(StdCIMV2Wmi wmi, Consumer<MSFT_NetTCPConnection> client){
        if( wmi==null )throw new IllegalArgumentException("wmi==null");
        if( client==null )throw new IllegalArgumentException("client==null");
        wmi.subclassesOf("MSFT_NetTCPConnection", obj -> client.accept(new MSFT_NetTCPConnectionImpl(obj)) );
    }

    public static List<MSFT_NetTCPConnection> query(StdCIMV2Wmi wmi){
        if( wmi==null )throw new IllegalArgumentException("wmi==null");
        ArrayList<MSFT_NetTCPConnection> list = new ArrayList<>();
        query(wmi,list::add);
        return list;
    }
}
