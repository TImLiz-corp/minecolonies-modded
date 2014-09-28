package com.minecolonies.colony.buildings;

import com.minecolonies.colony.CitizenData;
import com.minecolonies.colony.Colony;
import com.minecolonies.colony.ColonyView;
import com.minecolonies.entity.EntityCitizen;
import com.minecolonies.lib.EnumGUI;
import com.minecolonies.util.Utils;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.Constants;

import java.util.*;

public class BuildingHome extends BuildingHut
{
    private Set<UUID> citizens = new HashSet<UUID>();

    public BuildingHome(Colony c, ChunkCoordinates l)
    {
        super(c, l);
    }

    public String getSchematicName() { return "Citizen"; }
    public int getMaxInhabitants() { return 2; }

    @Override
    public int getGuiId() { return EnumGUI.CITIZEN.getID(); }

    @Override
    public void onDestroyed()
    {
        //  TODO REFACTOR - Ideally we should have a live Map of references to our CitizenData
        for (UUID tenant : citizens)
        {
            CitizenData citizen = getColony().getCitizen(tenant);
            if (citizen != null)
            {
                citizen.setHomeBuilding(null);
            }
        }

        super.onDestroyed();
    }

    @Override
    public void onWorldTick(TickEvent.WorldTickEvent event)
    {
        if (event.phase != TickEvent.Phase.END)
        {
            return;
        }

        if (citizens.size() < getMaxInhabitants())
        {
            //  'Capture' as many citizens into this house as possible
            addHomelessCitizens();
        }
    }

    public void addHomelessCitizens()
    {
        for (CitizenData citizen : getColony().getCitizens().values())
        {
            if (citizen.getHomeBuilding() == null)
            {
                citizens.add(citizen.getId());
                citizen.setHomeBuilding(this);

                if (citizens.size() >= getMaxInhabitants())
                {
                    break;
                }
            }
        }
    }

    @Override
    public void removeCitizen(UUID citizenId)
    {
        citizens.remove(citizenId);
    }

    public boolean isCitizen(EntityCitizen citizen)
    {
        return citizens.contains(citizen.getUniqueID());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        citizens.clear();

        NBTTagList nbtTagCitizenList = compound.getTagList("citizens", Constants.NBT.TAG_STRING);
        for(int i = 0; i < nbtTagCitizenList.tagCount(); i++)
        {
            UUID uuid = UUID.fromString(nbtTagCitizenList.getStringTagAt(i));
            citizens.add(uuid);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        NBTTagList nbtTagCitizenList = new NBTTagList();
        for(UUID citizen : citizens)
        {
            nbtTagCitizenList.appendTag(new NBTTagString(citizen.toString()));
        }
        compound.setTag("citizens", nbtTagCitizenList);
    }

    public static class View extends BuildingHut.View
    {
        public View(ColonyView c, ChunkCoordinates l)
        {
            super(c, l);
        }


        public GuiScreen getGui(EntityPlayer player, World world, int guiId, int x, int y, int z)
        {
            if (guiId == EnumGUI.CITIZEN.getID())
            {
                //return new GuiHutCitizen(this, player, world, x, y, z);
            }

            return null;
        }

    }
}
