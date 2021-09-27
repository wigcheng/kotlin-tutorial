class hero {
  private var name: String = ""
  private var skill: skillType = skillType.NORMAL
  private var hp: Int = 500
  private var mp: Int = 200
  private var strength: Int = 50
  private var wisdom: Int = 20
  private var defense: Int = 150

  enum class skillType {
    NORMAL,
    POISON,
    WATERBALL
  }

  fun set_name(player_name: String, player_skill: skillType) {
    var temp_str: String

    this.name = player_name
    this.skill = player_skill

    when(player_skill){
      skillType.NORMAL -> temp_str = "一般物理攻擊"
      skillType.POISON -> temp_str = "毒咒"
      else -> temp_str = "一般物理攻擊"
    }

    println("玩家" + this.name + "已進場, 自帶招式" + temp_str)
  }

  fun attack(target_hero: hero) {

    when(skill){
      skillType.NORMAL -> {
        println(name + "使用了物理攻擊")
        target_hero.lostHP(5);
      }
      skillType.POISON -> {
        println(name + "使用了毒咒")
        target_hero.lostHP(50);
      }
      else -> {
        println(name + "使用了物理攻擊")
        target_hero.lostHP(5);
      }
    }
    println(target_hero.name + "剩餘血量為" + target_hero.get_hp())
  }

  fun lostHP(lost_hp: Int) {
    set_hp(get_hp() - lost_hp)
  }

  fun set_hp(hp: Int) {
    this.hp = hp
  }

  fun getName(): String {
    return name
  }

  fun get_hp(): Int {
    if (this.hp <= 0)
      this.hp = 0

    return hp
  }
}
