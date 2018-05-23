public class LogMessage {

	private String machineID;
	private String description;

	// PART A
	public LogMessage(String message) {
		machineID = message.split(":")[0];
		description = message.split(":")[1];
	}

	// PART B
	public boolean containsWord(String keyword) {
		String[] words = description.split(" ");
		for (String s : words) {
			if (s.equals(keyword)) return true;
		}
		return false;
	}

	public String getMachineId() {
		return machineID;
	}

	public String getDescription() {
		return description;
	}
}
