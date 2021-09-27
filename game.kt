fun main(){
  var player = Array(2) { hero() }
  var turn : Int= 1

  println("=====大英雄天團M=====")

  println("=====遊戲開始=====")
  player[0].set_name("Wig", hero.skillType.NORMAL)
  player[1].set_name("Grace", hero.skillType.POISON)

  println("Wig 目前血量 " + player[0].get_hp())
  println("Grace 目前血量 " + player[1].get_hp())

  while( player[0].get_hp() > 0 && player[1].get_hp() > 0 ) {
    if (turn == 0)
      turn = 1
    else
      turn = 0

    player[0].attack(player[1])
    player[1].attack(player[0])
  }

  println("勝利者為" + player[turn].getName())
  println("=====遊戲結束=====")
}
