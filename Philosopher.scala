package classsicalPhilosopher
import org.apache.zookeeper._
import java.util.concurrent.Semaphore
import scala.util.Random

case class Philosopher(name:String,
                      hostPort:String,
                      root:String,
                      leftFork:Semaphore,
                      rightFork:Semaphore) extends  Watcher {


  val philosopherPath =  root+"/"+name
  val zk = new ZooKeeper(hostPort, 3000, this)
  val mutex = new Object()

  override def process(event: WatchedEvent): Unit = {
    mutex.synchronized {
      mutex.notify()
    }
  }

    }
  def eat(): Unit = {
      zk.create(philosopherPath, Array.emptyByteArray, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL)
      mutex.synchronized {


        println(s"${name} entered.")

        println(s"${name} is hungry")
        rightFork.acquire()
        println(s"${name} takes right fork")
        leftFork.acquire()
        println(s"${name} takes left fork")
        println(s"${name} starts eating")
        val sleepTime = (Random.nextInt(9) + 1) * 1000 
        Thread.sleep(sleepTime)
        println(s"${name} stops eating")
        rightFork.release()
        println(s"${name} releases right fork")
        leftFork.release()
        println(s"${name} releases left fork")
      }
    }

  def think(): Unit = {
    println(s"${name} starts thinking")
    zk.delete(philosopherPath, -1)
    Thread.sleep((Random.nextInt(9) + 1) * 1000)
    println(s"${name} stops thinking")
  }

}


