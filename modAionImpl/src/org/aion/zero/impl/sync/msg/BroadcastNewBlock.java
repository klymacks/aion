/*******************************************************************************
 * Copyright (c) 2017-2018 Aion foundation.
 *
 *     This file is part of the aion network project.
 *
 *     The aion network project is free software: you can redistribute it
 *     and/or modify it under the terms of the GNU General Public License
 *     as published by the Free Software Foundation, either version 3 of
 *     the License, or any later version.
 *
 *     The aion network project is distributed in the hope that it will
 *     be useful, but WITHOUT ANY WARRANTY; without even the implied
 *     warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *     See the GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with the aion network project source files.
 *     If not, see <https://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Aion foundation.
 *     
 ******************************************************************************/
package org.aion.zero.impl.sync.msg;

import org.aion.base.type.IBlock;
import org.aion.p2p.CTRL;
import org.aion.p2p.IMsg;
import org.aion.p2p.P2pVer;
import org.aion.rlp.RLP;
import org.aion.zero.impl.sync.ACT;

public final class BroadcastNewBlock implements IMsg {

    private final static byte ctrl = CTRL.SYNC0;

    private final static byte act = ACT.BROADCAST_NEWBLOCK;

    @SuppressWarnings("rawtypes")
    private final IBlock block;

    public BroadcastNewBlock(@SuppressWarnings("rawtypes") final IBlock __newblock) {
        this.block = __newblock;
    }

    public short getVer() {
        return P2pVer.VER0;
    }

    @Override
    public byte[] encode() {
        return this.block.getEncoded();
    }

    public static byte[] decode(final byte[] _msgBytes) {
        return RLP.decode2OneItem(_msgBytes, 0).getRLPData();
    }

    @Override
    public byte getCtrl() {
        return ctrl;
    }

    @Override
    public byte getAct() {
        return act;
    }

}