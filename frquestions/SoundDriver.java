public class SoundDriver {

  public static void main(String[] args) {

    int[] soundSamples = {40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223};

    Sound sound = new Sound(soundSamples);

    System.out.println("\nTrimming the first sound sample's amplitude...");
    sound.limitAmplitude(2000);
    int[] trimmmedSamples = sound.getSamples();
    System.out.println("The program should output:\n\t40 2000 17 -2000 -17 -2000 2000 1048 -420 33 15 -32 2000 2000");
    System.out.print("Your program outputs:\n\t");
    for (int value : trimmmedSamples)
      System.out.print(" " + value);


    Sound sound2 = new Sound( new int[] {0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0} );

    System.out.println("\n\nTrimming the second sound sample's silence...");
    sound2.trimSilenceFromBeginning();
    int[] trimmmedSamples2 = sound2.getSamples();
    System.out.println("The program should output:\n\t-14 0 -35 -39 0 -7 16 32 37 29 0 0 ");
    System.out.print("Your program outputs:\n\t");
    for (int value : trimmmedSamples2)
      System.out.print(" " + value);


  }

}
