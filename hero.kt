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
    FIREGOD_GO
  }

  fun set_name(player_name: String, player_skill: skillType) {
    var temp_str: String

    this.name = player_name
    this.skill = player_skill

    when(player_skill){
      skillType.NORMAL -> temp_str = "一般物理攻擊"
      skillType.POISON -> temp_str = "毒咒"
      skillType.FIREGOD_GO -> temp_str = "火神-陽華突"
    }

    println("玩家" + this.name + "已進場, 自帶招式" + temp_str)
  }

  fun attack(target_hero: hero) {

    when(skill){
      skillType.NORMAL -> {
        println(name + "使用了物理攻擊")
        target_hero.lostHP(5)
      }
      skillType.POISON -> {
        if(get_mp() > 0) {
          println(name + "使用了毒咒")
          lostMP(50)
          target_hero.lostHP(50)
        } else {
           println(name + "使用了毒咒,可是沒魔了啦！切換物理攻擊")
           this.skill = skillType.NORMAL
           attack(target_hero)
           return
        }
      }
      skillType.FIREGOD_GO -> {
        if(get_mp() > 0) {
          println(name + "使用了火神-陽華突")
          lostMP(100)
          target_hero.lostHP(150)
        } else {
           println(name + "使用了火神-陽華突,可是沒魔了啦！切換物理攻擊")
           this.skill = skillType.NORMAL
           attack(target_hero)
           return
        }
      }
    }
    println(target_hero.name + "剩餘血量為" + target_hero.get_hp())
  }

  fun lostHP(lost_hp: Int) {
    set_hp(get_hp() - lost_hp)
  }

  fun lostMP(lost_mp: Int) {
    set_mp(get_mp() - lost_mp)
  }

  fun set_hp(hp: Int) {
    this.hp = hp
  }

  fun set_mp(mp: Int) {
    this.mp = mp
  }

  fun getName(): String {
    return name
  }

  fun get_mp(): Int {
    if (this.mp <= 0)
      this.mp = 0

    return mp
  }

  fun get_hp(): Int {
    if (this.hp <= 0)
      this.hp = 0

    return hp
  }
}
