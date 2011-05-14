package com.intellij.structuralsearch.duplicates;

import com.intellij.dupLocator.DuplicatesProfile;
import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.plugins.groovy.GroovyFileType;
import org.jetbrains.plugins.groovy.lang.lexer.TokenSets;
import org.jetbrains.plugins.groovy.lang.psi.api.statements.GrStatement;

/**
 * @author Eugene.Kudelevsky
 */
public class GroovyDuplicatesProfile extends SSRDuplicatesProfile {
  @Override
  protected boolean isMyLanguage(@NotNull Language language) {
    return language.isKindOf(GroovyFileType.GROOVY_LANGUAGE);
  }

  @Override
  public int getNodeCost(@NotNull PsiElement element) {
    if (element instanceof GrStatement) {
      return 2;
    }
    return 0;
  }

  @Override
  public TokenSet getLiterals() {
    return TokenSets.CONSTANTS;
  }
}