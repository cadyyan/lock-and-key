# Lock And Key

Lock and Key is a Forge mod for Minecraft that adds locks and keys for doors and chests.
It is heavily inspired by the [BetterStorage](https://github.com/copygirl/BetterStorage) mod by
CopyGirl.

## Design Goals

1. Minecraft 1.8 compatible
	* Consider 1.9 compatibility when Forge is released
2. Support for Vanilla blocks
	* Small chest
	* Large chest
	* Wood door
	* Iron door
	* Double doors
3. Locks and keys are tied together
	* Keys can only open certain locks
4. Locks and keys can be color coded
	* Start with base 16 color options
	* Could add multiple color bands
	* Don't do compound colors
5. Locks can be removed from blocks with a key
	* Shift + Right click with key to remove lock
6. Keys and locks can be copied
	* Crafting a new lock/key with an existing one copies it
7. Locks can be picked using lock pick
	* Requires luck
	* Certain lock picks are better than others
	* If successful lock is removed from block
8. Lock picks can break
	* When picking a lock there's a chance of failure
	* On failure there's a chance of damaging the pick
	* When enough damage is incurred the pick will break
	* Better materials can take more damage
	* Better materials get damaged less often
9. Locks and keys can break
	* Using a key on a lock has a chance of damaging either item
	* When enough damage is incurred the item will break
	* Better materials can take more damage
	* Better materials get damaged less often
10. Picking a lock has a small chance of damaging the lock
	* Better materials can take more damage
	* Better materials get damaged less often
11. Locks, keys, and picks can be made of different materials
12. Locks can be enchanted for different effects
	* Effects might be to make the lock more durable
	* Might prevent lock picking
13. Keys can be enchanted for different effects
	* Might make the key more durable
14. Keys can be grouped together on a key ring
15. Skeleton key for admins/OPs
	* Creative only
	* Can open all locks
16. Some village chests might be locked
17. Chests in the mines might be locked
18. Dungeon chests might be locked
19. Support for other mods
	* Materials
	* Enchantments
	* Chests, doors, and other objects lockable

