package org.cloudfoundry.identity.uaa.scim;

import org.cloudfoundry.identity.uaa.scim.util.json.ScimGroupJsonDeserializer;
import org.cloudfoundry.identity.uaa.scim.util.json.ScimGroupJsonSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Arrays;
import java.util.List;

@JsonSerialize(using = ScimGroupJsonSerializer.class, include = JsonSerialize.Inclusion.NON_NULL)
@JsonDeserialize(using = ScimGroupJsonDeserializer.class)
public class ScimGroup extends ScimCore {

	private String displayName;
	private List<ScimGroupMember> members;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<ScimGroupMember> getMembers() {
		return members;
	}

	public void setMembers(List<ScimGroupMember> members) {
		this.members = members;
	}

	public ScimGroup() {
	}

	public ScimGroup(String name) {
		this.displayName = name;
	}

	public ScimGroup(String id, String name) {
		super(id);
		this.displayName = name;
	}

	@Override
	public String toString() {
		return String.format("(Group id: %s, name: %s, created: %s, modified: %s, version: %s, members: %s)", getId(), displayName, getMeta().getCreated(), getMeta().getLastModified(), getVersion(), members);
	}
}
