/*
 * Copyright 2000-2007 JetBrains s.r.o.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.plugins.groovy.lang.completion.filters.toplevel;

import com.intellij.psi.filters.ElementFilter;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.plugins.groovy.lang.psi.GroovyFile;
import org.jetbrains.plugins.groovy.lang.completion.GroovyCompletionUtil;

/**
 * @author ilyas
 */
public class ImportFilter implements ElementFilter {
  public boolean isAcceptable(Object element, PsiElement context) {
    if (context.getParent() != null &&
        !(context.getParent() instanceof PsiErrorElement) &&
        GroovyCompletionUtil.isNewStatement(context, false) &&
        context.getParent().getParent() instanceof GroovyFile) {
      return true;
    }
    return false;
  }

  public boolean isClassAcceptable(Class hintClass) {
    return true;
  }

  @NonNls
  public String toString() {
    return "'import' keyword filter";
  }
}
