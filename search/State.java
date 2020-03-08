package search;

import java.util.Set;

public interface State {
	Set<? extends Action> getApplicableActions();
	State getActionResult(Action action);
	public int hashCode();
	public boolean equals(Object that);
}
