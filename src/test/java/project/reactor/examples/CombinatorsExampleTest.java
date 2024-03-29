package project.reactor.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class CombinatorsExampleTest {

  private CombinatorsExample subject;

  @BeforeEach
  public void setup() {
    subject = new CombinatorsExample();
  }

  @Test
  public void shouldConcat() {
    var flux = subject.concat();

    StepVerifier.create(flux)
        .expectNext("A", "B", "C", "D", "E", "F")
        .verifyComplete();
  }

  @Test
  public void shouldConcatWith() {
    var flux = subject.concatWith();

    StepVerifier.create(flux)
        .expectNext("A", "B", "C", "D", "E", "F")
        .verifyComplete();
  }

  @Test
  public void shouldConcatMonoWith() {
    var flux = subject.concatWithMono();

    StepVerifier.create(flux)
        .expectNext("A", "B")
        .verifyComplete();
  }

  @Test
  public void shouldMergeFlux() {
    var flux = subject.merge();

    StepVerifier.create(flux)
        .expectNext("A", "B", "G", "C", "D", "E", "H", "F", "I", "J")
        .verifyComplete();
  }

  @Test
  public void shouldMergeMono() {
    var flux = subject.mergeMono();

    StepVerifier.create(flux)
        .expectNext("A", "B")
        .verifyComplete();
  }

  @Test
  public void shouldMergeSequential() {
    var flux = subject.mergeSequential();

    StepVerifier.create(flux)
        .expectNext("A", "B", "C", "D", "E", "F")
        .verifyComplete();
  }

  @Test
  public void shouldZip() {
    var flux = subject.zip();

    StepVerifier.create(flux)
        .expectNext("A-D", "B-E", "C-F")
        .verifyComplete();
  }

  @Test
  public void shouldZip4() {
    var flux = subject.zip4();

    StepVerifier.create(flux)
        .expectNext("AD14", "BE25", "CF36")
        .verifyComplete();
  }

  @Test
  public void shouldZipFluxWithMono() {
    var flux = subject.zipFluxWithMono();

    StepVerifier.create(flux)
        .expectNext("B-A")
        .verifyComplete();
  }

  @Test
  public void shouldZipMonoWithMono() {
    var mono = subject.zipMonoWithMono();

    StepVerifier.create(mono)
        .expectNext("A-B")
        .verifyComplete();
  }
}
