package protocolsupport.protocol.packet.middle.serverbound.play;

import protocolsupport.protocol.packet.ServerBoundPacket;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.ServerBoundPacketData;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public abstract class MiddleEntityAction extends ServerBoundMiddlePacket {

	protected int entityId;
	protected Action action;
	protected int jumpBoost;

	@Override
	public RecyclableCollection<ServerBoundPacketData> toNative() {
		ServerBoundPacketData creator = ServerBoundPacketData.create(ServerBoundPacket.PLAY_ENTITY_ACTION);
		VarNumberSerializer.writeVarInt(creator, entityId);
		MiscSerializer.writeEnum(creator, action);
		VarNumberSerializer.writeVarInt(creator, jumpBoost);
		return RecyclableSingletonList.create(creator);
	}

	protected static enum Action {
		START_SNEAK, STOP_SNEAK, LEAVE_BED, START_SPRINT, STOP_SPRINT, START_JUMP, STOP_JUMP, OPEN_HORSE_INV, START_ELYTRA_FLY;
	}

}
