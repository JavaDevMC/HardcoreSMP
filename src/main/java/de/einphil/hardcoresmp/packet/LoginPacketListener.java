package de.einphil.hardcoresmp.packet;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketAdapter;
import de.einphil.hardcoresmp.HardcoreSMP;
import net.minecraft.network.protocol.Packet;

public class LoginPacketListener extends PacketAdapter
{

    /**
     * listens for login packets to edit
     *
     * @param bukkitPlugin the plugin
     */
    public LoginPacketListener(HardcoreSMP bukkitPlugin)
    {
        //listen for login packets on the normal priority
        super(bukkitPlugin, ListenerPriority.NORMAL, PacketType.Play.Server.LOGIN);
    }

    @Override
    public void onPacketSending(PacketEvent event)
    {
        //if its a login packet write the first boolean to true (hardcore flag)
        if(event.getPacketType().equals(PacketType.Play.Server.LOGIN)) {
            event.getPacket().getBooleans().write(0, true);
        }
    }
}
