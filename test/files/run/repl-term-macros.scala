import scala.tools.partest.ReplTest

object Test extends ReplTest {
  def code = """
  import scala.reflect.macros.Context
import language.experimental.macros

def impl1(c: Context) = { import c.universe._; c.Expr[Unit](q"()") }
def foo1 = macro impl1
foo1

def impl2(c: Context)() = { import c.universe._; c.Expr[Unit](q"()") }
def foo2() = macro impl2
foo2()

def impl3(c: Context)(x: c.Expr[Int])(y: c.Expr[Int]) = { import c.universe._; c.Expr[Unit](q"()") }
def foo3(x: Int)(y: Int) = macro impl3
foo3(2)(3)
  """
}