import java.io.*;
import java.util.*;

public class ParticleSimulation {

    public static class Particle {
        public double rx, ry, rz;  // position
        public double vx, vy, vz;  // velocity
        private final double radius;
        private final double mass;

        public Particle(double rx, double ry, double rz, double vx, double vy, double vz, double radius, double mass) {
            this.rx = rx;
            this.ry = ry;
            this.rz = rz;
            this.vx = vx;
            this.vy = vy;
            this.vz = vz;
            this.radius = radius;
            this.mass = mass;
        }

        public double velocityMagnitude() {
            return Math.sqrt(vx * vx + vy * vy + vz * vz);
        }

        public double momentum() {
            return mass * velocityMagnitude();
        }

        public double kineticEnergy() {
            double vMag = velocityMagnitude();
            return 0.5 * mass * vMag * vMag;
        }
    }

    private static List<Double> velocities = new ArrayList<>();
    private static List<Double> momenta = new ArrayList<>();
    private static List<Double> kineticEnergies = new ArrayList<>();

    public static void main(String[] args) {
        List<Particle> particles = new ArrayList<>();

        // Read dataset
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\shreevats\\OneDrive\\Desktop\\Project\\large_particle_system_dataset.csv"))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double rx = Double.parseDouble(values[1]);
                double ry = Double.parseDouble(values[2]);
                double rz = Double.parseDouble(values[3]);
                double vx = Double.parseDouble(values[4]);
                double vy = Double.parseDouble(values[5]);
                double vz = Double.parseDouble(values[6]);
                double mass = Double.parseDouble(values[7]);
                double radius = Double.parseDouble(values[8]);

                Particle p = new Particle(rx, ry, rz, vx, vy, vz, radius, mass);
                particles.add(p);
                velocities.add(p.velocityMagnitude());
                momenta.add(p.momentum());
                kineticEnergies.add(p.kineticEnergy());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Write data to CSV files
        writeDataToFile("velocities.csv", velocities);
        writeDataToFile("momenta.csv", momenta);
        writeDataToFile("kinetic_energies.csv", kineticEnergies);
    }

    private static void writeDataToFile(String filename, List<Double> data) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for (Double value : data) {
                writer.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
