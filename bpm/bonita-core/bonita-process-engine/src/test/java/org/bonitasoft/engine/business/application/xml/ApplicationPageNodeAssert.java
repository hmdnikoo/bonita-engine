package org.bonitasoft.engine.business.application.xml;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * {@link ApplicationPageNode} specific assertions - Generated by CustomAssertionGenerator.
 */
public class ApplicationPageNodeAssert extends AbstractAssert<ApplicationPageNodeAssert, ApplicationPageNode> {

  /**
   * Creates a new <code>{@link ApplicationPageNodeAssert}</code> to make assertions on actual ApplicationPageNode.
   * @param actual the ApplicationPageNode we want to make assertions on.
   */
  public ApplicationPageNodeAssert(ApplicationPageNode actual) {
    super(actual, ApplicationPageNodeAssert.class);
  }

  /**
   * An entry point for ApplicationPageNodeAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myApplicationPageNode)</code> and get specific assertion with code completion.
   * @param actual the ApplicationPageNode we want to make assertions on.
   * @return a new <code>{@link ApplicationPageNodeAssert}</code>
   */
  public static ApplicationPageNodeAssert assertThat(ApplicationPageNode actual) {
    return new ApplicationPageNodeAssert(actual);
  }

  /**
   * Verifies that the actual ApplicationPageNode's customPage is equal to the given one.
   * @param customPage the given customPage to compare the actual ApplicationPageNode's customPage to.
   * @return this assertion object.
   * @throws AssertionError - if the actual ApplicationPageNode's customPage is not equal to the given one.
   */
  public ApplicationPageNodeAssert hasCustomPage(String customPage) {
    // check that actual ApplicationPageNode we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected customPage of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualCustomPage = actual.getCustomPage();
    if (!Objects.areEqual(actualCustomPage, customPage)) {
      failWithMessage(assertjErrorMessage, actual, customPage, actualCustomPage);
    }

    // return the current assertion for method chaining
    return this;
  }

  /**
   * Verifies that the actual ApplicationPageNode's token is equal to the given one.
   * @param token the given token to compare the actual ApplicationPageNode's token to.
   * @return this assertion object.
   * @throws AssertionError - if the actual ApplicationPageNode's token is not equal to the given one.
   */
  public ApplicationPageNodeAssert hasToken(String token) {
    // check that actual ApplicationPageNode we want to make assertions on is not null.
    isNotNull();

    // overrides the default error message with a more explicit one
    String assertjErrorMessage = "\nExpected token of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";
    
    // null safe check
    String actualToken = actual.getToken();
    if (!Objects.areEqual(actualToken, token)) {
      failWithMessage(assertjErrorMessage, actual, token, actualToken);
    }

    // return the current assertion for method chaining
    return this;
  }

}