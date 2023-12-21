import java.util.concurrent.Semaphore

object Main {
  def main(args: Array[String]): Unit = {
    philosophers()
  }

  def philosophers(): Unit = {
    val hostname = "127.0.0.1"
    val names: List[String] = List("Plato","Confucius ","Socrates"," Voltaire", "Decartes" )
    val root = "/philosophers"
    val places = 5
    val forks = new Array[Semaphore](places)
    for (i <- 0 until places) {
      forks(i) = new Semaphore(1)
    }
    val philosophers = new Array[Thread](places)
    for (i <- 0 until places) {
      philosophers(i) = new Thread(
        () => {
          val philosopher = Philosopher(i, hostPort, root, forks(i), forks((i + 1) % places))
          while (true) {
            philosopher.eat()
            philosopher.think()
          }
        }
      )
      philosophers(i).start()
    }
  }
}