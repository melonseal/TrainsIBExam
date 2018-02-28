public class Runner {

    public class Train
    {
        private Engine[] mEngines;
        private Wagon[] mWagons;
        private int mEngineCount;
        private int mWagonCount;
        private int mTrainNumber;
        private double mWeight; // Total weight in kilograms

        public Train(int number)
        {
            mTrainNumber = number;
            mEngines = new Engine[6]; // The train can have up to 6 engines
            mEngineCount = 0;
            mWagons = new Wagon[100]; // The train can have up to 100 wagons
            mWagonCount = 0;
            mWeight = 0;
        }
        public void addEngine( Engine newEngine )
        {
            mEngines[mEngineCount] = newEngine;
            mEngineCount++;
        }
        public Engine removeEngine()
        {
            mEngineCount--;
            return mEngines[mEngineCount];
        }
        public void addWagon( Wagon newWagon )
        {
            mWagons[mWagonCount] = newWagon;
            mWagonCount++;
        }
        public int getNumberofWagons(){
            return this.mWagonCount;
        }
        public Wagon removeWagon()
        {
            Wagon returnWagon;
            if(this.mWagonCount > 0){
                this.mWagonCount --;
                returnWagon = this.mWagons[this.mWagonCount];
            }else{
                returnWagon = null;
            }
            return returnWagon;
        }
        public double getWeight()
        {
            double total = 0;
            for(int i = 0; i < this.mEngineCount; i++){
                total += this.mEngines[i].getWeight();
            }
            for(int j = 0; j < this.mWagonCount; j++){
                total += this.mWagons[j].getWeight();
            }
            return total;
        }
…
    }


    public class RollingStock
    {
        private int mIDNumber;
        private double mWeight;

        public RollingStock(int ID, double weight)
        {
            mIDNumber = ID;
            mWeight = weight; // Weight is in kilograms
        }

        // Accessor methods
        public double getWeight() { return mWeight; }
        public int getID() { return mIDNumber; }
...

// Other methods
        …
    }



    public class Engine extends RollingStock
    {
        private double mPullingWeight; // maximum weight engine can pull

        public Engine(int ID)
        {
            super(ID, 120000); // Engines weigh 120000 kilograms
            mPullingWeight = 1400000; // Engines can pull 1400000 kilograms
        }
        // Accessor methods
        public double getWeight() { return super.getWeight(); }
...
// Other methods
        …
    }


    public class Wagon extends RollingStock
    {
        private Parcel[] mParcels;
        private int mParcelCount;

        public Wagon(int ID)
        {
            super(ID, 32000); // Empty wagon weighs 32000 kilograms
            mParcels = new Parcel[100];
            mParcelCount = 0;
        }

        // Accessor methods
        public int getWagonID() { return this.getID(); }
        public double getWeight()
        {
            double thisWeight = 0;
            for(int i = 0; i < this.mParcelCount; i++){
                thisWeight += this.mParcels[i].getWeight();
            }
            thisWeight += super.getWeight();
            return thisWeight;
        }
...
// Other methods
        …
    }


    public class Parcel
    {
        private int trackingID;
        private double weight;
        public String destinationAddress;
        public String originAddress;

        public Parcel(int ID) {
            trackingID = ID;
            weight = 0;
        }
        public void setWeight(double newWeight) { weight = newWeight; }
        public double getWeight() { return weight; }
    }


}
