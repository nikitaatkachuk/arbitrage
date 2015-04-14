package by.arbitrage.html;

import by.arbitrage.entity.site.SiteEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Nikita Tkachuk
 */
@Entity
@Table(name = "user_forms")
public class UserSiteForm
{
	@Id
	@GeneratedValue
	private Long id;

	protected String formId;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "form_classes", joinColumns = @JoinColumn(name = "user_form_id"))
	@Column(name = "form_class")
	protected Set<String> formClasses;


	public UserSiteForm()
	{
	}

	public UserSiteForm(String formId, Set<String> formClasses)
	{
		this.formId = formId;
		this.formClasses = formClasses;
	}
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFormId()
	{
		return formId;
	}

	public void setFormId(String formId)
	{
		this.formId = formId;
	}

	public Set<String> getFormClasses()
	{
		return formClasses;
	}

	public void setFormClasses(Set<String> formClasses)
	{
		this.formClasses = formClasses;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (!(o instanceof UserSiteForm)) return false;

		UserSiteForm that = (UserSiteForm) o;

		if (!formClasses.equals(that.formClasses)) return false;
		if (!formId.equals(that.formId)) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + formId.hashCode();
		result = 31 * result + formClasses.hashCode();
		return result;
	}
}
