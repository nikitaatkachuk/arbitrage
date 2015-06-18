package by.arbitrage.integration.piwik;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: nikita tkachuk
 * Date: 6/18/2015
 * Time: 6:38 AM
 */
@JsonAutoDetect
public class PiwikDataResponseGenericObject
{

	/**
	 *  Number of unique visitors
	 */

	@JsonProperty("nb_uniq_visitors")
	public long uniqueVisitorNumber;

	/**
	 * Number of Visits (30 min of inactivity considered a new visit)
	 */

	@JsonProperty("nb_visits")
	public long numberOfVisits;

	/**
	 * Number of unique active users (visitors with a known User ID).
	 * If you are not using User ID then this metric will be set to zero
	 */

	@JsonProperty("nb_users")
	public long usersNumber;

	/**
	 * Number of actions (page views, outlinks and downloads)
	 */

	@JsonProperty("nb_actions")
	public long actionsNumber;

	/**
	 * Total time spent, in seconds
	 */

	@JsonProperty("sum_visit_length")
	public long timeSpent;

	/**
	 * Number of visits that bounced (viewed only one page)
	 */

	@JsonProperty("bounce_count")
	public long bounceCount;

	/**
	 * Maximum number of actions in a visit
	 */

	@JsonProperty("max_actions")
	public long maxActions;

	/**
	 * Number of visits that converted a goal
	 */

	@JsonProperty("nb_visits_converted")
	public long visitsToGoal;

	/**
	 * Number of goal conversions
	 */

	@JsonProperty("nb_conversions")
	public long conversion;

	/**
	 * Total revenue of goal conversions
	 */

	@JsonProperty("revenue")
	public long revenue ;

}
