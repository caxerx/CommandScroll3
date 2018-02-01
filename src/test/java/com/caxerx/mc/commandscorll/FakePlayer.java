package com.caxerx.mc.commandscorll;

import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.InetSocketAddress;
import java.util.*;

public class FakePlayer implements Player {
    @Override
    public String getDisplayName() {
        return "caxerx";
    }

    @Override
    public void setDisplayName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public String getPlayerListName() {
        return "caxerx";
    }

    @Override
    public void setPlayerListName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public void setCompassTarget(Location loc) {
        throw new NotImplementedException();
    }

    @Override
    public Location getCompassTarget() {
        throw new NotImplementedException();
    }

    @Override
    public InetSocketAddress getAddress() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isConversing() {
        throw new NotImplementedException();
    }

    @Override
    public void acceptConversationInput(String input) {
        throw new NotImplementedException();
    }

    @Override
    public boolean beginConversation(Conversation conversation) {
        throw new NotImplementedException();
    }

    @Override
    public void abandonConversation(Conversation conversation) {
        throw new NotImplementedException();
    }

    @Override
    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        throw new NotImplementedException();
    }

    @Override
    public void sendRawMessage(String message) {
        throw new NotImplementedException();
    }

    @Override
    public void kickPlayer(String message) {
        throw new NotImplementedException();
    }

    @Override
    public void chat(String msg) {
        throw new NotImplementedException();
    }

    @Override
    public boolean performCommand(String command) {
        System.out.println("Fake player performed command:" + command);
        return true;
    }

    @Override
    public boolean isSneaking() {
        throw new NotImplementedException();
    }

    @Override
    public void setSneaking(boolean sneak) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSprinting() {
        throw new NotImplementedException();
    }

    @Override
    public void setSprinting(boolean sprinting) {
        throw new NotImplementedException();
    }

    @Override
    public void saveData() {
        throw new NotImplementedException();
    }

    @Override
    public void loadData() {
        throw new NotImplementedException();
    }

    @Override
    public void setSleepingIgnored(boolean isSleeping) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSleepingIgnored() {
        throw new NotImplementedException();
    }

    @Override
    public void playNote(Location loc, byte instrument, byte note) {
        throw new NotImplementedException();
    }

    @Override
    public void playNote(Location loc, Instrument instrument, Note note) {
        throw new NotImplementedException();
    }

    @Override
    public void playSound(Location location, Sound sound, float volume, float pitch) {
        throw new NotImplementedException();
    }

    @Override
    public void playSound(Location location, String sound, float volume, float pitch) {
        throw new NotImplementedException();
    }

    @Override
    public void playSound(Location location, Sound sound, SoundCategory category, float volume, float pitch) {
        throw new NotImplementedException();
    }

    @Override
    public void playSound(Location location, String sound, SoundCategory category, float volume, float pitch) {
        throw new NotImplementedException();
    }

    @Override
    public void stopSound(Sound sound) {
        throw new NotImplementedException();
    }

    @Override
    public void stopSound(String sound) {
        throw new NotImplementedException();
    }

    @Override
    public void stopSound(Sound sound, SoundCategory category) {
        throw new NotImplementedException();
    }

    @Override
    public void stopSound(String sound, SoundCategory category) {
        throw new NotImplementedException();
    }

    @Override
    public void playEffect(Location loc, Effect effect, int data) {
        throw new NotImplementedException();
    }

    @Override
    public <T> void playEffect(Location loc, Effect effect, T data) {
        throw new NotImplementedException();
    }

    @Override
    public void sendBlockChange(Location loc, Material material, byte data) {
        throw new NotImplementedException();
    }

    @Override
    public boolean sendChunkChange(Location loc, int sx, int sy, int sz, byte[] data) {
        throw new NotImplementedException();
    }

    @Override
    public void sendBlockChange(Location loc, int material, byte data) {
        throw new NotImplementedException();
    }

    @Override
    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void sendMap(MapView map) {
        throw new NotImplementedException();
    }

    @Override
    public void updateInventory() {
        throw new NotImplementedException();
    }

    @Override
    public void awardAchievement(Achievement achievement) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAchievement(Achievement achievement) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasAchievement(Achievement achievement) {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        throw new NotImplementedException();
    }

    @Override
    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        throw new NotImplementedException();
    }

    @Override
    public void setPlayerTime(long time, boolean relative) {
        throw new NotImplementedException();
    }

    @Override
    public long getPlayerTime() {
        throw new NotImplementedException();
    }

    @Override
    public long getPlayerTimeOffset() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPlayerTimeRelative() {
        throw new NotImplementedException();
    }

    @Override
    public void resetPlayerTime() {
        throw new NotImplementedException();
    }

    @Override
    public void setPlayerWeather(WeatherType type) {
        throw new NotImplementedException();
    }

    @Override
    public WeatherType getPlayerWeather() {
        throw new NotImplementedException();
    }

    @Override
    public void resetPlayerWeather() {
        throw new NotImplementedException();
    }

    @Override
    public void giveExp(int amount) {
        throw new NotImplementedException();
    }

    @Override
    public void giveExpLevels(int amount) {
        throw new NotImplementedException();
    }

    @Override
    public float getExp() {
        throw new NotImplementedException();
    }

    @Override
    public void setExp(float exp) {
        throw new NotImplementedException();
    }

    @Override
    public int getLevel() {
        throw new NotImplementedException();
    }

    @Override
    public void setLevel(int level) {
        throw new NotImplementedException();
    }

    @Override
    public int getTotalExperience() {
        throw new NotImplementedException();
    }

    @Override
    public void setTotalExperience(int exp) {
        throw new NotImplementedException();
    }

    @Override
    public float getExhaustion() {
        throw new NotImplementedException();
    }

    @Override
    public void setExhaustion(float value) {
        throw new NotImplementedException();
    }

    @Override
    public float getSaturation() {
        throw new NotImplementedException();
    }

    @Override
    public void setSaturation(float value) {
        throw new NotImplementedException();
    }

    @Override
    public int getFoodLevel() {
        throw new NotImplementedException();
    }

    @Override
    public void setFoodLevel(int value) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOnline() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBanned() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isWhitelisted() {
        throw new NotImplementedException();
    }

    @Override
    public void setWhitelisted(boolean value) {
        throw new NotImplementedException();
    }

    @Override
    public Player getPlayer() {
        return this;
    }

    @Override
    public long getFirstPlayed() {
        throw new NotImplementedException();
    }

    @Override
    public long getLastPlayed() {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasPlayedBefore() {
        throw new NotImplementedException();
    }

    @Override
    public Location getBedSpawnLocation() {
        throw new NotImplementedException();
    }

    @Override
    public void setBedSpawnLocation(Location location) {
        throw new NotImplementedException();
    }

    @Override
    public void setBedSpawnLocation(Location location, boolean force) {
        throw new NotImplementedException();
    }

    @Override
    public boolean getAllowFlight() {
        throw new NotImplementedException();
    }

    @Override
    public void setAllowFlight(boolean flight) {
        throw new NotImplementedException();
    }

    @Override
    public void hidePlayer(Player player) {
        throw new NotImplementedException();
    }

    @Override
    public void hidePlayer(Plugin plugin, Player player) {
        throw new NotImplementedException();
    }

    @Override
    public void showPlayer(Player player) {
        throw new NotImplementedException();
    }

    @Override
    public void showPlayer(Plugin plugin, Player player) {
        throw new NotImplementedException();
    }

    @Override
    public boolean canSee(Player player) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isFlying() {
        throw new NotImplementedException();
    }

    @Override
    public void setFlying(boolean value) {
        throw new NotImplementedException();
    }

    @Override
    public void setFlySpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public void setWalkSpeed(float value) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public float getFlySpeed() {
        throw new NotImplementedException();
    }

    @Override
    public float getWalkSpeed() {
        throw new NotImplementedException();
    }

    @Override
    public void setTexturePack(String url) {
        throw new NotImplementedException();
    }

    @Override
    public void setResourcePack(String url) {
        throw new NotImplementedException();
    }

    @Override
    public void setResourcePack(String url, byte[] hash) {
        throw new NotImplementedException();
    }

    @Override
    public Scoreboard getScoreboard() {
        throw new NotImplementedException();
    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isHealthScaled() {
        throw new NotImplementedException();
    }

    @Override
    public void setHealthScaled(boolean scale) {
        throw new NotImplementedException();
    }

    @Override
    public void setHealthScale(double scale) throws IllegalArgumentException {
        throw new NotImplementedException();
    }

    @Override
    public double getHealthScale() {
        throw new NotImplementedException();
    }

    @Override
    public Entity getSpectatorTarget() {
        throw new NotImplementedException();
    }

    @Override
    public void setSpectatorTarget(Entity entity) {
        throw new NotImplementedException();
    }

    @Override
    public void sendTitle(String title, String subtitle) {
        throw new NotImplementedException();
    }

    @Override
    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        throw new NotImplementedException();
    }

    @Override
    public void resetTitle() {
        throw new NotImplementedException();
    }

    @Override
    public void spawnParticle(Particle particle, Location location, int count) {
        throw new NotImplementedException();
    }

    @Override
    public void spawnParticle(Particle particle, double x, double y, double z, int count) {
        throw new NotImplementedException();
    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int count, T data) {
        throw new NotImplementedException();
    }

    @Override
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, T data) {
        throw new NotImplementedException();
    }

    @Override
    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ) {
        throw new NotImplementedException();
    }

    @Override
    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ) {
        throw new NotImplementedException();
    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, T data) {
        throw new NotImplementedException();
    }

    @Override
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data) {
        throw new NotImplementedException();
    }

    @Override
    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        throw new NotImplementedException();
    }

    @Override
    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        throw new NotImplementedException();
    }

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data) {
        throw new NotImplementedException();
    }

    @Override
    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data) {
        throw new NotImplementedException();
    }

    @Override
    public AdvancementProgress getAdvancementProgress(Advancement advancement) {
        throw new NotImplementedException();
    }

    @Override
    public String getLocale() {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> serialize() {
        throw new NotImplementedException();
    }

    @Override
    public String getName() {
        return "caxerx";
    }

    @Override
    public PlayerInventory getInventory() {
        throw new NotImplementedException();
    }

    @Override
    public Inventory getEnderChest() {
        throw new NotImplementedException();
    }

    @Override
    public MainHand getMainHand() {
        throw new NotImplementedException();
    }

    @Override
    public boolean setWindowProperty(InventoryView.Property prop, int value) {
        throw new NotImplementedException();
    }

    @Override
    public InventoryView getOpenInventory() {
        throw new NotImplementedException();
    }

    @Override
    public InventoryView openInventory(Inventory inventory) {
        throw new NotImplementedException();
    }

    @Override
    public InventoryView openWorkbench(Location location, boolean force) {
        throw new NotImplementedException();
    }

    @Override
    public InventoryView openEnchanting(Location location, boolean force) {
        throw new NotImplementedException();
    }

    @Override
    public void openInventory(InventoryView inventory) {
        throw new NotImplementedException();
    }

    @Override
    public InventoryView openMerchant(Villager trader, boolean force) {
        throw new NotImplementedException();
    }

    @Override
    public InventoryView openMerchant(Merchant merchant, boolean force) {
        throw new NotImplementedException();
    }

    @Override
    public void closeInventory() {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getItemInHand() {
        throw new NotImplementedException();
    }

    @Override
    public void setItemInHand(ItemStack item) {
        throw new NotImplementedException();
    }

    @Override
    public ItemStack getItemOnCursor() {
        throw new NotImplementedException();
    }

    @Override
    public void setItemOnCursor(ItemStack item) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasCooldown(Material material) {
        throw new NotImplementedException();
    }

    @Override
    public int getCooldown(Material material) {
        throw new NotImplementedException();
    }

    @Override
    public void setCooldown(Material material, int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSleeping() {
        throw new NotImplementedException();
    }

    @Override
    public int getSleepTicks() {
        throw new NotImplementedException();
    }

    @Override
    public GameMode getGameMode() {
        throw new NotImplementedException();
    }

    @Override
    public void setGameMode(GameMode mode) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBlocking() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isHandRaised() {
        throw new NotImplementedException();
    }

    @Override
    public int getExpToLevel() {
        throw new NotImplementedException();
    }

    @Override
    public Entity getShoulderEntityLeft() {
        throw new NotImplementedException();
    }

    @Override
    public void setShoulderEntityLeft(Entity entity) {
        throw new NotImplementedException();
    }

    @Override
    public Entity getShoulderEntityRight() {
        throw new NotImplementedException();
    }

    @Override
    public void setShoulderEntityRight(Entity entity) {
        throw new NotImplementedException();
    }

    @Override
    public double getEyeHeight() {
        throw new NotImplementedException();
    }

    @Override
    public double getEyeHeight(boolean ignoreSneaking) {
        throw new NotImplementedException();
    }

    @Override
    public Location getEyeLocation() {
        throw new NotImplementedException();
    }

    @Override
    public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
        throw new NotImplementedException();
    }

    @Override
    public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
        throw new NotImplementedException();
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) {
        throw new NotImplementedException();
    }

    @Override
    public int getRemainingAir() {
        throw new NotImplementedException();
    }

    @Override
    public void setRemainingAir(int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public int getMaximumAir() {
        throw new NotImplementedException();
    }

    @Override
    public void setMaximumAir(int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public int getMaximumNoDamageTicks() {
        throw new NotImplementedException();
    }

    @Override
    public void setMaximumNoDamageTicks(int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public double getLastDamage() {
        throw new NotImplementedException();
    }

    @Override
    public void setLastDamage(double damage) {
        throw new NotImplementedException();
    }

    @Override
    public int getNoDamageTicks() {
        throw new NotImplementedException();
    }

    @Override
    public void setNoDamageTicks(int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public Player getKiller() {
        throw new NotImplementedException();
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addPotionEffect(PotionEffect effect, boolean force) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addPotionEffects(Collection<PotionEffect> effects) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasPotionEffect(PotionEffectType type) {
        throw new NotImplementedException();
    }

    @Override
    public PotionEffect getPotionEffect(PotionEffectType type) {
        throw new NotImplementedException();
    }

    @Override
    public void removePotionEffect(PotionEffectType type) {
        throw new NotImplementedException();
    }

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasLineOfSight(Entity other) {
        throw new NotImplementedException();
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        throw new NotImplementedException();
    }

    @Override
    public void setRemoveWhenFarAway(boolean remove) {
        throw new NotImplementedException();
    }

    @Override
    public EntityEquipment getEquipment() {
        throw new NotImplementedException();
    }

    @Override
    public void setCanPickupItems(boolean pickup) {
        throw new NotImplementedException();
    }

    @Override
    public boolean getCanPickupItems() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLeashed() {
        throw new NotImplementedException();
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        throw new NotImplementedException();
    }

    @Override
    public boolean setLeashHolder(Entity holder) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isGliding() {
        throw new NotImplementedException();
    }

    @Override
    public void setGliding(boolean gliding) {
        throw new NotImplementedException();
    }

    @Override
    public void setAI(boolean ai) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasAI() {
        throw new NotImplementedException();
    }

    @Override
    public void setCollidable(boolean collidable) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCollidable() {
        throw new NotImplementedException();
    }

    @Override
    public AttributeInstance getAttribute(Attribute attribute) {
        throw new NotImplementedException();
    }

    @Override
    public void damage(double amount) {
        throw new NotImplementedException();
    }

    @Override
    public void damage(double amount, Entity source) {
        throw new NotImplementedException();
    }

    @Override
    public double getHealth() {
        throw new NotImplementedException();
    }

    @Override
    public void setHealth(double health) {
        throw new NotImplementedException();
    }

    @Override
    public double getMaxHealth() {
        throw new NotImplementedException();
    }

    @Override
    public void setMaxHealth(double health) {
        throw new NotImplementedException();
    }

    @Override
    public void resetMaxHealth() {
        throw new NotImplementedException();
    }

    @Override
    public Location getLocation() {
        return new Location(new FakeWorld(), Math.random()*10000-5000, Math.random()*256, Math.random()*10000-5000);
    }

    @Override
    public Location getLocation(Location loc) {
        throw new NotImplementedException();
    }

    @Override
    public void setVelocity(Vector velocity) {
        throw new NotImplementedException();
    }

    @Override
    public Vector getVelocity() {
        throw new NotImplementedException();
    }

    @Override
    public double getHeight() {
        throw new NotImplementedException();
    }

    @Override
    public double getWidth() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOnGround() {
        throw new NotImplementedException();
    }

    @Override
    public World getWorld() {
        throw new NotImplementedException();
    }

    @Override
    public boolean teleport(Location location) {
        throw new NotImplementedException();
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        throw new NotImplementedException();
    }

    @Override
    public boolean teleport(Entity destination) {
        throw new NotImplementedException();
    }

    @Override
    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        throw new NotImplementedException();
    }

    @Override
    public List<Entity> getNearbyEntities(double x, double y, double z) {
        throw new NotImplementedException();
    }

    @Override
    public int getEntityId() {
        throw new NotImplementedException();
    }

    @Override
    public int getFireTicks() {
        throw new NotImplementedException();
    }

    @Override
    public int getMaxFireTicks() {
        throw new NotImplementedException();
    }

    @Override
    public void setFireTicks(int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public void remove() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isDead() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isValid() {
        throw new NotImplementedException();
    }

    @Override
    public void sendMessage(String message) {
        throw new NotImplementedException();
    }

    @Override
    public void sendMessage(String[] messages) {
        throw new NotImplementedException();
    }

    @Override
    public Server getServer() {
        throw new NotImplementedException();
    }

    @Override
    public Entity getPassenger() {
        throw new NotImplementedException();
    }

    @Override
    public boolean setPassenger(Entity passenger) {
        throw new NotImplementedException();
    }

    @Override
    public List<Entity> getPassengers() {
        throw new NotImplementedException();
    }

    @Override
    public boolean addPassenger(Entity passenger) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removePassenger(Entity passenger) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isEmpty() {
        throw new NotImplementedException();
    }

    @Override
    public boolean eject() {
        throw new NotImplementedException();
    }

    @Override
    public float getFallDistance() {
        throw new NotImplementedException();
    }

    @Override
    public void setFallDistance(float distance) {
        throw new NotImplementedException();
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent event) {
        throw new NotImplementedException();
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        throw new NotImplementedException();
    }

    @Override
    public UUID getUniqueId() {
        return UUID.randomUUID();
    }

    @Override
    public int getTicksLived() {
        throw new NotImplementedException();
    }

    @Override
    public void setTicksLived(int value) {
        throw new NotImplementedException();
    }

    @Override
    public void playEffect(EntityEffect type) {
        throw new NotImplementedException();
    }

    @Override
    public EntityType getType() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isInsideVehicle() {
        throw new NotImplementedException();
    }

    @Override
    public boolean leaveVehicle() {
        throw new NotImplementedException();
    }

    @Override
    public Entity getVehicle() {
        throw new NotImplementedException();
    }

    @Override
    public void setCustomNameVisible(boolean flag) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isCustomNameVisible() {
        throw new NotImplementedException();
    }

    @Override
    public void setGlowing(boolean flag) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isGlowing() {
        throw new NotImplementedException();
    }

    @Override
    public void setInvulnerable(boolean flag) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isInvulnerable() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isSilent() {
        throw new NotImplementedException();
    }

    @Override
    public void setSilent(boolean flag) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasGravity() {
        throw new NotImplementedException();
    }

    @Override
    public void setGravity(boolean gravity) {
        throw new NotImplementedException();
    }

    @Override
    public int getPortalCooldown() {
        throw new NotImplementedException();
    }

    @Override
    public void setPortalCooldown(int cooldown) {
        throw new NotImplementedException();
    }

    @Override
    public Set<String> getScoreboardTags() {
        throw new NotImplementedException();
    }

    @Override
    public boolean addScoreboardTag(String tag) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeScoreboardTag(String tag) {
        throw new NotImplementedException();
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        throw new NotImplementedException();
    }

    @Override
    public String getCustomName() {
        throw new NotImplementedException();
    }

    @Override
    public void setCustomName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        throw new NotImplementedException();
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasMetadata(String metadataKey) {
        throw new NotImplementedException();
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPermissionSet(String name) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasPermission(String name) {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasPermission(Permission perm) {
        throw new NotImplementedException();
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        throw new NotImplementedException();
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        throw new NotImplementedException();
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        throw new NotImplementedException();
    }

    @Override
    public void recalculatePermissions() {
        throw new NotImplementedException();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOp() {
        throw new NotImplementedException();
    }

    @Override
    public void setOp(boolean value) {
        throw new NotImplementedException();
    }

    @Override
    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        throw new NotImplementedException();
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        throw new NotImplementedException();
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        throw new NotImplementedException();
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        throw new NotImplementedException();
    }
}
