public class LogMessageDriver {

	public static void main(String[] args) {

		LogMessage msg1 = new LogMessage("CLIENT3:security alert - repeated login failures");
		LogMessage msg2 = new LogMessage("Webserver:disk offline");
		LogMessage msg3 = new LogMessage("SERVER1:file not found");
		LogMessage msg4 = new LogMessage("SERVER2:read error on disk DSK1");
		LogMessage msg5 = new LogMessage("SERVER3:error on disk3");

		System.out.println(msg1.getMachineId());
		System.out.println(msg1.getDescription());

		System.out.println(msg2.containsWord("disk"));
		System.out.println(msg4.containsWord("disk"));
		System.out.println(msg5.containsWord("disk"));

	}

}
