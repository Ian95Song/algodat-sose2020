import java.util.ArrayList;

/**
 * The class Neuron implents a interneuron for the class Network.
 *
 * @author Vera Röhr
 * @version 1.0
 * @since 2019-01-11
 */
public class Interneuron extends Neuron {
    /**
     * {@inheritDoc}
     */
    public Interneuron(int index) {
        // TODO
        super(index);
        this.index = index;
        this.outgoingsynapses = new ArrayList<>();
    }



    /**
     * Divides incoming signal into equal parts for all the outgoing synapses
     * Transmits the parts via Synapse.transmit(Double[]);
     *
     * @param signal 3 dimensional signal from another neuron
     * @return 3 dimensional neural signal, which got transmitted to the synapses (for testing.)
     */
    @Override
    public double[] integrateSignal(double[] signal) {
        // TODO
        double[] temp = new double[3];

        if (this.outgoingsynapses.isEmpty())
            return signal;
        else
            for (int c = 0; c < 3; c++) {
                temp[c] = signal[c] / this.outgoingsynapses.size();
            }
        for (Synapse outgoingsynaps : this.outgoingsynapses) {
            outgoingsynaps.transmit(temp);
        }
            return temp;
    }

}


