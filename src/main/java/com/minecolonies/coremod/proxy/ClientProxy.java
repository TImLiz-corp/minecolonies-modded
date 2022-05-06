package com.minecolonies.coremod.proxy;

import com.ldtteam.structurize.helpers.Settings;
import com.ldtteam.structurize.management.Structures;
import com.minecolonies.api.colony.ICitizenDataView;
import com.minecolonies.api.colony.IColonyManager;
import com.minecolonies.api.colony.IColonyView;
import com.minecolonies.api.util.Log;
import com.minecolonies.api.util.constant.Constants;
import com.minecolonies.apiimp.ClientMinecoloniesAPIImpl;
import com.minecolonies.coremod.client.gui.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.stats.RecipeBook;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

import static com.ldtteam.structurize.api.util.constant.Constants.GROUNDSTYLE_RELATIVE;

/**
 * Client side proxy.
 */
@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientProxy extends CommonProxy
{
    public ClientProxy()
    {
        apiImpl = new ClientMinecoloniesAPIImpl();
    }

    @Override
    public boolean isClient()
    {
        return true;
    }

    @Override
    public void showCitizenWindow(final ICitizenDataView citizen)
    {
        @NotNull final WindowInteraction window = new WindowInteraction(citizen);
        window.open();
    }

    @Override
    public void openBuildToolWindow(@Nullable final BlockPos pos)
    {
        if (pos == null && Settings.instance.getActiveStructure() == null)
        {
            return;
        }

        @Nullable final WindowMinecoloniesBuildTool window = new WindowMinecoloniesBuildTool(pos, GROUNDSTYLE_RELATIVE);
        window.open();
    }

    @Override
    public void openShapeToolWindow(@Nullable final BlockPos pos)
    {
        if (pos == null && Settings.instance.getActiveStructure() == null)
        {
            return;
        }

        @Nullable final WindowMinecoloniesShapeTool window = new WindowMinecoloniesShapeTool(pos);
        window.open();
    }

    @Override
    public void openDecorationControllerWindow(@Nullable final BlockPos pos)
    {
        if (pos == null)
        {
            return;
        }

        @Nullable final WindowDecorationController window = new WindowDecorationController(pos);
        window.open();
    }

    @Override
    public Level getWorld(final ResourceKey<Level> dimension)
    {
        return Minecraft.getInstance().level;
    }

    @Override
    public void openSuggestionWindow(@NotNull final BlockPos pos, @NotNull final BlockState state, @NotNull final ItemStack stack)
    {
        new WindowSuggestBuildTool(pos, state, stack).open();
    }

    @Override
    public void openBuildToolWindow(final BlockPos pos, final String structureName, final int rotation, final int groundstyle)
    {
        if (pos == null && Settings.instance.getActiveStructure() == null)
        {
            return;
        }

        @Nullable final WindowMinecoloniesBuildTool window = new WindowMinecoloniesBuildTool(pos, structureName, rotation, groundstyle);
        window.open();
    }

    @Override
    public void openBannerRallyGuardsWindow(final ItemStack banner)
    {
        @Nullable final WindowBannerRallyGuards window = new WindowBannerRallyGuards(banner);
        window.open();
    }

    @Override
    public void openClipboardWindow(final IColonyView colonyView)
    {
        @Nullable final WindowClipBoard window = new WindowClipBoard(colonyView);
        window.open();
    }

    @Override
    public void openResourceScrollWindow(
      final int colonyId,
      final BlockPos buildingPos,
      final @Nullable BlockPos warehousePos,
      final @Nullable CompoundTag warehouseCompound)
    {
        @Nullable final WindowResourceList window = new WindowResourceList(colonyId, buildingPos, warehousePos, warehouseCompound);
        window.open();
    }

    @Override
    public File getSchematicsFolder()
    {
        if (net.minecraftforge.server.ServerLifecycleHooks.getCurrentServer() == null)
        {
            if (IColonyManager.getInstance().getServerUUID() != null)
            {
                return new File(Minecraft.getInstance().gameDirectory, Constants.MOD_ID + "/" + IColonyManager.getInstance().getServerUUID());
            }
            else
            {
                Log.getLogger().error("ColonyManager.getServerUUID() => null this should not happen", new Exception());
                return null;
            }
        }

        // if the world schematics folder exists we use it
        // otherwise we use the minecraft folder  /minecolonies/schematics if on the physical client on the logical server
        final File worldSchematicFolder = new File(ServerLifecycleHooks.getCurrentServer().getServerDirectory()
                                                     + "/" + Constants.MOD_ID + '/' + Structures.SCHEMATICS_PREFIX);

        if (!worldSchematicFolder.exists())
        {
            return new File(Minecraft.getInstance().gameDirectory, Constants.MOD_ID);
        }

        return worldSchematicFolder.getParentFile();
    }

    @NotNull
    @Override
    public RecipeBook getRecipeBookFromPlayer(@NotNull final Player player)
    {
        if (player instanceof LocalPlayer)
        {
            return ((LocalPlayer) player).getRecipeBook();
        }

        return super.getRecipeBookFromPlayer(player);
    }
}
