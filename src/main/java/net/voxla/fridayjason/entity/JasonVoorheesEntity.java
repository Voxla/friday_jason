
package net.voxla.fridayjason.entity;

import software.bernie.geckolib3.util.GeckoLibUtil;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.IAnimatable;

import net.voxla.fridayjason.procedures.JasonVoorheesThisEntityKillsAnotherOneProcedure;
import net.voxla.fridayjason.procedures.JasonVoorheesOnInitialEntitySpawnProcedure;
import net.voxla.fridayjason.procedures.JasonVoorheesOnEntityTickUpdateProcedure;
import net.voxla.fridayjason.procedures.JasonVoorheesEntityDiesProcedure;
import net.voxla.fridayjason.procedures.JasonVoorheesDeathTimeIsReachedProcedure;
import net.voxla.fridayjason.procedures.JasonVoorheesBoundingBoxScaleProcedure;
import net.voxla.fridayjason.procedures.CanJasonMoveAndLookAroundProcedure;
import net.voxla.fridayjason.init.FridayJasonModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

public class JasonVoorheesEntity extends Monster implements IAnimatable {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_IsPlayerNotNearSoundTimer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_TimesJasonHasHitPlayer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_BloodCounter = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_IsSeen = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_HasPlayerFoundThisJason = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_AiStage = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_JasonSneakPathfindTimer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_DoorBashAmount = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_DoorBashTime = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Stage3AiGen = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_BaseAiSpawnGen = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_WaitBeforeTryingToPathToPlayer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_JasonDespawnTimer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_DoorBashAmountResetTime = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_HasGrabbedPlayer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_GrabPlayerCooldown = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_JasonStoredPlayerCoordX = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_JasonStoredPlayerCoordZ = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_JasonSearchCoordX = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_JasonSearchCoordZ = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_SearchTimer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_SetPlayerHeartBeatTimerSearch = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_SetPlayerHeartBeatTimerChase = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_IsTargettingEntity = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_JasonSearchMusic = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_JasonChaseMusic = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Stage3AiGenRandFor3 = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_BashPlayersShieldCounter = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_PlayerStruggleAmount = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_IsDay = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_ThrowMacheteCooldownTimer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_HasPlayerBeenAboveJasonForTooLong = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_AiStage3Stage1Timer = SynchedEntityData.defineId(JasonVoorheesEntity.class, EntityDataSerializers.INT);
	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public JasonVoorheesEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(FridayJasonModEntities.JASON_VOORHEES.get(), world);
	}

	public JasonVoorheesEntity(EntityType<JasonVoorheesEntity> type, Level world) {
		super(type, world);
		xpReward = 100;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "jason");
		this.entityData.define(DATA_IsPlayerNotNearSoundTimer, 0);
		this.entityData.define(DATA_TimesJasonHasHitPlayer, 0);
		this.entityData.define(DATA_BloodCounter, 0);
		this.entityData.define(DATA_IsSeen, false);
		this.entityData.define(DATA_HasPlayerFoundThisJason, false);
		this.entityData.define(DATA_AiStage, 0);
		this.entityData.define(DATA_JasonSneakPathfindTimer, 0);
		this.entityData.define(DATA_DoorBashAmount, 0);
		this.entityData.define(DATA_DoorBashTime, 0);
		this.entityData.define(DATA_Stage3AiGen, 0);
		this.entityData.define(DATA_BaseAiSpawnGen, 0);
		this.entityData.define(DATA_WaitBeforeTryingToPathToPlayer, 0);
		this.entityData.define(DATA_JasonDespawnTimer, 0);
		this.entityData.define(DATA_DoorBashAmountResetTime, 0);
		this.entityData.define(DATA_HasGrabbedPlayer, false);
		this.entityData.define(DATA_GrabPlayerCooldown, 0);
		this.entityData.define(DATA_JasonStoredPlayerCoordX, 0);
		this.entityData.define(DATA_JasonStoredPlayerCoordZ, 0);
		this.entityData.define(DATA_JasonSearchCoordX, 0);
		this.entityData.define(DATA_JasonSearchCoordZ, 0);
		this.entityData.define(DATA_SearchTimer, 0);
		this.entityData.define(DATA_SetPlayerHeartBeatTimerSearch, 0);
		this.entityData.define(DATA_SetPlayerHeartBeatTimerChase, 0);
		this.entityData.define(DATA_IsTargettingEntity, 0);
		this.entityData.define(DATA_JasonSearchMusic, 0);
		this.entityData.define(DATA_JasonChaseMusic, 0);
		this.entityData.define(DATA_Stage3AiGenRandFor3, 0);
		this.entityData.define(DATA_BashPlayersShieldCounter, 0);
		this.entityData.define(DATA_PlayerStruggleAmount, 0);
		this.entityData.define(DATA_IsDay, false);
		this.entityData.define(DATA_ThrowMacheteCooldownTimer, 0);
		this.entityData.define(DATA_HasPlayerBeenAboveJasonForTooLong, 0);
		this.entityData.define(DATA_AiStage3Stage1Timer, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Villager.class, true, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Evoker.class, true, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Pillager.class, true, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Vindicator.class, true, false));
		this.goalSelector.addGoal(6, new MeleeAttackGoal(this, 1, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 9;
			}
		});
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = JasonVoorheesEntity.this.getX();
				double y = JasonVoorheesEntity.this.getY();
				double z = JasonVoorheesEntity.this.getZ();
				Entity entity = JasonVoorheesEntity.this;
				Level world = JasonVoorheesEntity.this.level;
				return super.canUse() && CanJasonMoveAndLookAroundProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JasonVoorheesEntity.this.getX();
				double y = JasonVoorheesEntity.this.getY();
				double z = JasonVoorheesEntity.this.getZ();
				Entity entity = JasonVoorheesEntity.this;
				Level world = JasonVoorheesEntity.this.level;
				return super.canContinueToUse() && CanJasonMoveAndLookAroundProcedure.execute(entity);
			}
		});
		this.targetSelector.addGoal(8, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(9, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = JasonVoorheesEntity.this.getX();
				double y = JasonVoorheesEntity.this.getY();
				double z = JasonVoorheesEntity.this.getZ();
				Entity entity = JasonVoorheesEntity.this;
				Level world = JasonVoorheesEntity.this.level;
				return super.canUse() && CanJasonMoveAndLookAroundProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = JasonVoorheesEntity.this.getX();
				double y = JasonVoorheesEntity.this.getY();
				double z = JasonVoorheesEntity.this.getZ();
				Entity entity = JasonVoorheesEntity.this;
				Level world = JasonVoorheesEntity.this.level;
				return super.canContinueToUse() && CanJasonMoveAndLookAroundProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(10, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.jason.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("friday_jason:entity.jason.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		if (source == DamageSource.LIGHTNING_BOLT)
			return false;
		if (source == DamageSource.DRAGON_BREATH)
			return false;
		if (source == DamageSource.WITHER)
			return false;
		if (source.getMsgId().equals("witherSkull"))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		JasonVoorheesEntityDiesProcedure.execute(this.level, source.getEntity());
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		JasonVoorheesOnInitialEntitySpawnProcedure.execute(this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		compound.putInt("DataIsPlayerNotNearSoundTimer", this.entityData.get(DATA_IsPlayerNotNearSoundTimer));
		compound.putInt("DataTimesJasonHasHitPlayer", this.entityData.get(DATA_TimesJasonHasHitPlayer));
		compound.putInt("DataBloodCounter", this.entityData.get(DATA_BloodCounter));
		compound.putBoolean("DataIsSeen", this.entityData.get(DATA_IsSeen));
		compound.putBoolean("DataHasPlayerFoundThisJason", this.entityData.get(DATA_HasPlayerFoundThisJason));
		compound.putInt("DataAiStage", this.entityData.get(DATA_AiStage));
		compound.putInt("DataJasonSneakPathfindTimer", this.entityData.get(DATA_JasonSneakPathfindTimer));
		compound.putInt("DataDoorBashAmount", this.entityData.get(DATA_DoorBashAmount));
		compound.putInt("DataDoorBashTime", this.entityData.get(DATA_DoorBashTime));
		compound.putInt("DataStage3AiGen", this.entityData.get(DATA_Stage3AiGen));
		compound.putInt("DataBaseAiSpawnGen", this.entityData.get(DATA_BaseAiSpawnGen));
		compound.putInt("DataWaitBeforeTryingToPathToPlayer", this.entityData.get(DATA_WaitBeforeTryingToPathToPlayer));
		compound.putInt("DataJasonDespawnTimer", this.entityData.get(DATA_JasonDespawnTimer));
		compound.putInt("DataDoorBashAmountResetTime", this.entityData.get(DATA_DoorBashAmountResetTime));
		compound.putBoolean("DataHasGrabbedPlayer", this.entityData.get(DATA_HasGrabbedPlayer));
		compound.putInt("DataGrabPlayerCooldown", this.entityData.get(DATA_GrabPlayerCooldown));
		compound.putInt("DataJasonStoredPlayerCoordX", this.entityData.get(DATA_JasonStoredPlayerCoordX));
		compound.putInt("DataJasonStoredPlayerCoordZ", this.entityData.get(DATA_JasonStoredPlayerCoordZ));
		compound.putInt("DataJasonSearchCoordX", this.entityData.get(DATA_JasonSearchCoordX));
		compound.putInt("DataJasonSearchCoordZ", this.entityData.get(DATA_JasonSearchCoordZ));
		compound.putInt("DataSearchTimer", this.entityData.get(DATA_SearchTimer));
		compound.putInt("DataSetPlayerHeartBeatTimerSearch", this.entityData.get(DATA_SetPlayerHeartBeatTimerSearch));
		compound.putInt("DataSetPlayerHeartBeatTimerChase", this.entityData.get(DATA_SetPlayerHeartBeatTimerChase));
		compound.putInt("DataIsTargettingEntity", this.entityData.get(DATA_IsTargettingEntity));
		compound.putInt("DataJasonSearchMusic", this.entityData.get(DATA_JasonSearchMusic));
		compound.putInt("DataJasonChaseMusic", this.entityData.get(DATA_JasonChaseMusic));
		compound.putInt("DataStage3AiGenRandFor3", this.entityData.get(DATA_Stage3AiGenRandFor3));
		compound.putInt("DataBashPlayersShieldCounter", this.entityData.get(DATA_BashPlayersShieldCounter));
		compound.putInt("DataPlayerStruggleAmount", this.entityData.get(DATA_PlayerStruggleAmount));
		compound.putBoolean("DataIsDay", this.entityData.get(DATA_IsDay));
		compound.putInt("DataThrowMacheteCooldownTimer", this.entityData.get(DATA_ThrowMacheteCooldownTimer));
		compound.putInt("DataHasPlayerBeenAboveJasonForTooLong", this.entityData.get(DATA_HasPlayerBeenAboveJasonForTooLong));
		compound.putInt("DataAiStage3Stage1Timer", this.entityData.get(DATA_AiStage3Stage1Timer));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("DataIsPlayerNotNearSoundTimer"))
			this.entityData.set(DATA_IsPlayerNotNearSoundTimer, compound.getInt("DataIsPlayerNotNearSoundTimer"));
		if (compound.contains("DataTimesJasonHasHitPlayer"))
			this.entityData.set(DATA_TimesJasonHasHitPlayer, compound.getInt("DataTimesJasonHasHitPlayer"));
		if (compound.contains("DataBloodCounter"))
			this.entityData.set(DATA_BloodCounter, compound.getInt("DataBloodCounter"));
		if (compound.contains("DataIsSeen"))
			this.entityData.set(DATA_IsSeen, compound.getBoolean("DataIsSeen"));
		if (compound.contains("DataHasPlayerFoundThisJason"))
			this.entityData.set(DATA_HasPlayerFoundThisJason, compound.getBoolean("DataHasPlayerFoundThisJason"));
		if (compound.contains("DataAiStage"))
			this.entityData.set(DATA_AiStage, compound.getInt("DataAiStage"));
		if (compound.contains("DataJasonSneakPathfindTimer"))
			this.entityData.set(DATA_JasonSneakPathfindTimer, compound.getInt("DataJasonSneakPathfindTimer"));
		if (compound.contains("DataDoorBashAmount"))
			this.entityData.set(DATA_DoorBashAmount, compound.getInt("DataDoorBashAmount"));
		if (compound.contains("DataDoorBashTime"))
			this.entityData.set(DATA_DoorBashTime, compound.getInt("DataDoorBashTime"));
		if (compound.contains("DataStage3AiGen"))
			this.entityData.set(DATA_Stage3AiGen, compound.getInt("DataStage3AiGen"));
		if (compound.contains("DataBaseAiSpawnGen"))
			this.entityData.set(DATA_BaseAiSpawnGen, compound.getInt("DataBaseAiSpawnGen"));
		if (compound.contains("DataWaitBeforeTryingToPathToPlayer"))
			this.entityData.set(DATA_WaitBeforeTryingToPathToPlayer, compound.getInt("DataWaitBeforeTryingToPathToPlayer"));
		if (compound.contains("DataJasonDespawnTimer"))
			this.entityData.set(DATA_JasonDespawnTimer, compound.getInt("DataJasonDespawnTimer"));
		if (compound.contains("DataDoorBashAmountResetTime"))
			this.entityData.set(DATA_DoorBashAmountResetTime, compound.getInt("DataDoorBashAmountResetTime"));
		if (compound.contains("DataHasGrabbedPlayer"))
			this.entityData.set(DATA_HasGrabbedPlayer, compound.getBoolean("DataHasGrabbedPlayer"));
		if (compound.contains("DataGrabPlayerCooldown"))
			this.entityData.set(DATA_GrabPlayerCooldown, compound.getInt("DataGrabPlayerCooldown"));
		if (compound.contains("DataJasonStoredPlayerCoordX"))
			this.entityData.set(DATA_JasonStoredPlayerCoordX, compound.getInt("DataJasonStoredPlayerCoordX"));
		if (compound.contains("DataJasonStoredPlayerCoordZ"))
			this.entityData.set(DATA_JasonStoredPlayerCoordZ, compound.getInt("DataJasonStoredPlayerCoordZ"));
		if (compound.contains("DataJasonSearchCoordX"))
			this.entityData.set(DATA_JasonSearchCoordX, compound.getInt("DataJasonSearchCoordX"));
		if (compound.contains("DataJasonSearchCoordZ"))
			this.entityData.set(DATA_JasonSearchCoordZ, compound.getInt("DataJasonSearchCoordZ"));
		if (compound.contains("DataSearchTimer"))
			this.entityData.set(DATA_SearchTimer, compound.getInt("DataSearchTimer"));
		if (compound.contains("DataSetPlayerHeartBeatTimerSearch"))
			this.entityData.set(DATA_SetPlayerHeartBeatTimerSearch, compound.getInt("DataSetPlayerHeartBeatTimerSearch"));
		if (compound.contains("DataSetPlayerHeartBeatTimerChase"))
			this.entityData.set(DATA_SetPlayerHeartBeatTimerChase, compound.getInt("DataSetPlayerHeartBeatTimerChase"));
		if (compound.contains("DataIsTargettingEntity"))
			this.entityData.set(DATA_IsTargettingEntity, compound.getInt("DataIsTargettingEntity"));
		if (compound.contains("DataJasonSearchMusic"))
			this.entityData.set(DATA_JasonSearchMusic, compound.getInt("DataJasonSearchMusic"));
		if (compound.contains("DataJasonChaseMusic"))
			this.entityData.set(DATA_JasonChaseMusic, compound.getInt("DataJasonChaseMusic"));
		if (compound.contains("DataStage3AiGenRandFor3"))
			this.entityData.set(DATA_Stage3AiGenRandFor3, compound.getInt("DataStage3AiGenRandFor3"));
		if (compound.contains("DataBashPlayersShieldCounter"))
			this.entityData.set(DATA_BashPlayersShieldCounter, compound.getInt("DataBashPlayersShieldCounter"));
		if (compound.contains("DataPlayerStruggleAmount"))
			this.entityData.set(DATA_PlayerStruggleAmount, compound.getInt("DataPlayerStruggleAmount"));
		if (compound.contains("DataIsDay"))
			this.entityData.set(DATA_IsDay, compound.getBoolean("DataIsDay"));
		if (compound.contains("DataThrowMacheteCooldownTimer"))
			this.entityData.set(DATA_ThrowMacheteCooldownTimer, compound.getInt("DataThrowMacheteCooldownTimer"));
		if (compound.contains("DataHasPlayerBeenAboveJasonForTooLong"))
			this.entityData.set(DATA_HasPlayerBeenAboveJasonForTooLong, compound.getInt("DataHasPlayerBeenAboveJasonForTooLong"));
		if (compound.contains("DataAiStage3Stage1Timer"))
			this.entityData.set(DATA_AiStage3Stage1Timer, compound.getInt("DataAiStage3Stage1Timer"));
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		JasonVoorheesThisEntityKillsAnotherOneProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), entity, this);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		JasonVoorheesOnEntityTickUpdateProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		Entity entity = this;
		Level world = this.level;
		double x = this.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return super.getDimensions(p_33597_).scale((float) JasonVoorheesBoundingBoxScaleProcedure.execute(world, x, y, z));
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.23);
		builder = builder.add(Attributes.MAX_HEALTH, 250);
		builder = builder.add(Attributes.ARMOR, 20);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.jason.walk", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			if (this.isShiftKeyDown()) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.jason.idlesneak", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.jason.idle", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	private <E extends IAnimatable> PlayState attackingPredicate(AnimationEvent<E> event) {
		double d1 = this.getX() - this.xOld;
		double d0 = this.getZ() - this.zOld;
		float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
		if (getAttackAnim(event.getPartialTick()) > 0f && !this.swinging) {
			this.swinging = true;
			this.lastSwing = level.getGameTime();
		}
		if (this.swinging && this.lastSwing + 15L <= level.getGameTime()) {
			this.swinging = false;
		}
		if (this.swinging && event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
			event.getController().markNeedsReload();
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.jason.attack", EDefaultLoopTypes.PLAY_ONCE));
			return PlayState.CONTINUE;
		}
		return PlayState.CONTINUE;
	}

	private <E extends IAnimatable> PlayState procedurePredicate(AnimationEvent<E> event) {
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
			if (event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
				this.animationprocedure = "empty";
				event.getController().markNeedsReload();
			}
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 1) {
			this.remove(JasonVoorheesEntity.RemovalReason.KILLED);
			this.dropExperience();
			JasonVoorheesDeathTimeIsReachedProcedure.execute(this.level, this);
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.addAnimationController(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
		data.addAnimationController(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
}
