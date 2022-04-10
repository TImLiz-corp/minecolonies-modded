// Made with Blockbench 4.0.0-beta.0
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
package com.minecolonies.coremod.client.model;

import com.minecolonies.api.client.render.modeltype.CitizenModel;
import com.minecolonies.api.entity.citizen.AbstractEntityCitizen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class FemaleStudentModel extends CitizenModel<AbstractEntityCitizen>
{
    public FemaleStudentModel(final ModelPart part)
    {
        super(part);
        hat.visible = false;
    }

    public static LayerDefinition createMesh()
    {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bipedHead = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
          .texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hairback1_r1 = bipedHead.addOrReplaceChild("hairback1_r1", CubeListBuilder.create().texOffs(74, 0).addBox(-2.0F, -2.0F, -1.9F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
          .texOffs(74, 7).addBox(-1.0F, -1.0F, 1.1F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -4.9F, 5.9F, 0.1309F, 0.0F, 0.0F));

        PartDefinition HairExtension = bipedHead.addOrReplaceChild("HairExtension", CubeListBuilder.create().texOffs(56, 0).addBox(-4.0F, 0.0F, 3.0F, 8.0F, 7.0F, 1.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 1.0F, 0.0F));

        PartDefinition Ponytail = bipedHead.addOrReplaceChild("Ponytail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition ponyTailTip_r1 = Ponytail.addOrReplaceChild("ponyTailTip_r1", CubeListBuilder.create().texOffs(88, 55).mirror().addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -25.0F, 4.8F, 0.2231F, 0.0F, 0.0F));

        PartDefinition ponytailBase_r1 = Ponytail.addOrReplaceChild("ponytailBase_r1", CubeListBuilder.create().texOffs(86, 48).mirror().addBox(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -28.0F, 2.0F, 0.5577F, 0.0F, 0.0F));

        PartDefinition glasses = bipedHead.addOrReplaceChild("glasses", CubeListBuilder.create().texOffs(103, 0).addBox(-5.5F, -3.6F, -1.3F, 7.0F, 7.0F, 1.0F, new CubeDeformation(-2.0F))
          .texOffs(103, 8).addBox(-1.5F, -3.6F, -1.3F, 7.0F, 7.0F, 1.0F, new CubeDeformation(-2.0F))
          .texOffs(119, 0).addBox(-1.0F, -0.6F, -2.55F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F))
          .texOffs(114, 11).addBox(-4.8F, -0.9F, -2.89F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.6F))
          .texOffs(114, 18).addBox(2.8F, -0.9F, -2.89F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, -3.9F, -2.1F, 0.0873F, 0.0F, 0.0F));

        PartDefinition bipedBody = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
          .texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.49F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition breast = bipedBody.addOrReplaceChild("breast", CubeListBuilder.create().texOffs(64, 49).addBox(-3.0F, 1.8938F, -5.716F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
          .texOffs(64, 55).addBox(-3.0F, 1.8938F, -5.716F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.0F, 3.0F, 4.0F, -0.5236F, 0.0F, 0.0F));

        PartDefinition bipedRightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
          .texOffs(40, 32).addBox(-2.0F, -2.03F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.45F))
          .texOffs(64, 37).mirror().addBox(-1.7F, 7.5F, -3.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition bipedLeftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
          .texOffs(48, 48).addBox(-1.0F, -2.03F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.45F)), PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition rightFoldedArm = partdefinition.addOrReplaceChild("rightFoldedArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition rightShoulder = rightFoldedArm.addOrReplaceChild("rightShoulder", CubeListBuilder.create().texOffs(56, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
          .texOffs(72, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition rightForeArm = rightFoldedArm.addOrReplaceChild("rightForeArm", CubeListBuilder.create().texOffs(88, 16).addBox(-1.01F, -0.6F, -2.3F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
          .texOffs(88, 24).addBox(-1.01F, -0.6F, -2.3F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.251F)), PartPose.offsetAndRotation(-1.0F, 2.5F, -3.8F, -1.0472F, 0.0F, 0.0F));

        PartDefinition leftFoldedArm = partdefinition.addOrReplaceChild("leftFoldedArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition leftShoulder = leftFoldedArm.addOrReplaceChild("leftShoulder", CubeListBuilder.create().texOffs(56, 26).mirror().addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
          .texOffs(72, 26).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition leftForeArm = leftFoldedArm.addOrReplaceChild("leftForeArm", CubeListBuilder.create().texOffs(88, 32).mirror().addBox(-4.0F, -0.6F, -2.3F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
          .texOffs(88, 40).mirror().addBox(-4.0F, -0.6F, -2.3F, 7.0F, 3.0F, 4.0F, new CubeDeformation(0.252F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 2.5F, -3.8F, -1.0472F, 0.0F, 0.0F));

        PartDefinition bipedRightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
          .texOffs(0, 32).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition bipedLeftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
          .texOffs(0, 48).addBox(-1.95F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.591F)), PartPose.offset(1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }
}
