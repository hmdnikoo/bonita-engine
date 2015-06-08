package org.bonitasoft.engine.business.application.xml;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.internal.Iterables;

/**
 * {@link ApplicationNodeContainer} specific assertions - Generated by CustomAssertionGenerator.
 */
public class ApplicationNodeContainerAssert extends AbstractAssert<ApplicationNodeContainerAssert, ApplicationNodeContainer> {

  /**
   * Creates a new <code>{@link ApplicationNodeContainerAssert}</code> to make assertions on actual ApplicationNodeContainer.
   * @param actual the ApplicationNodeContainer we want to make assertions on.
   */
  public ApplicationNodeContainerAssert(ApplicationNodeContainer actual) {
    super(actual, ApplicationNodeContainerAssert.class);
  }

  /**
   * An entry point for ApplicationNodeContainerAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myApplicationNodeContainer)</code> and get specific assertion with code completion.
   * @param actual the ApplicationNodeContainer we want to make assertions on.
   * @return a new <code>{@link ApplicationNodeContainerAssert}</code>
   */
  public static ApplicationNodeContainerAssert assertThat(ApplicationNodeContainer actual) {
    return new ApplicationNodeContainerAssert(actual);
  }

  /**
   * Verifies that the actual ApplicationNodeContainer's applications contains the given ApplicationNode elements.
   * @param applications the given elements that should be contained in actual ApplicationNodeContainer's applications.
   * @return this assertion object.
   * @throws AssertionError if the actual ApplicationNodeContainer's applications does not contain all given ApplicationNode elements.
   */
  public ApplicationNodeContainerAssert hasApplications(ApplicationNode... applications) {
    // check that actual ApplicationNodeContainer we want to make assertions on is not null.
    isNotNull();

    // check that given ApplicationNode varargs is not null.
    if (applications == null) throw new AssertionError("Expecting applications parameter not to be null.");
    
    // check with standard error message, to set another message call: info.overridingErrorMessage("my error message");
    Iterables.instance().assertContains(info, actual.getApplications(), applications);

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual ApplicationNodeContainer has no applications.
   * @return this assertion object.
   * @throws AssertionError if the actual ApplicationNodeContainer's applications is not empty.
   */
  public ApplicationNodeContainerAssert hasNoApplications() {
    // check that actual ApplicationNodeContainer we want to make assertions on is not null.
    isNotNull();

    // we override the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected :\n  <%s>\nnot to have applications but had :\n  <%s>";
    
    // check
    if (actual.getApplications().iterator().hasNext()) {
      failWithMessage(assertjErrorMessage, actual, actual.getApplications());
    }
    
    // return the current assertion for method chaining
    return this;
  }
  

}