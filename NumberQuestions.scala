import java.io.{PrintWriter, File}

def write(input: Iterator[String], filename: String) = {
    val file = new File(filename + ".md")
    val bw = new PrintWriter(file)
    input.foreach(s => bw.write(s + "\n"))
    bw.close()
}

val lines = scala.io.Source.fromFile(args(0)).getLines

var nrQuestion = 0

val numberedQuestions = lines.map{ line => 
    if(line.startsWith("###")) {
        nrQuestion += 1
        line.replaceFirst("^###[\\s\\d.]*(\\w)", "### " + nrQuestion + ". $1")
    } else line
}

write(numberedQuestions, args(1))