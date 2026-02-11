package logisticsapp.models.enums;

public enum TruckBrand {

    SCANIA, MAN, ACTROS;

    @Override
    public String toString() {

        switch (this) {


            case SCANIA -> {
                return "Scania";
            }
            case MAN -> {
                return "Man";
            }
            case ACTROS -> {
                return "Actros";
            }
        }

            return "Invalid Type";
    }


}
