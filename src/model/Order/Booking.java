package model.Order;


public class Booking {

    private  String status, firstName, lastName, film, date, time, seat, idNumber, username;


    public Booking(String status, String username, String firstName, String lastName, String film, String date, String time, String price, String idNumber) {

        this.status = new String(status);
        this.firstName = new String(firstName);
        this.lastName = new String(lastName);
        this.film = new String(film);
        this.date = new String(date);
        this.time = new String(time);
        this.seat = new String(price);
        this.idNumber = new String(idNumber);
        this.username = username;
    }




    public String getStatus() {

        return status;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFilm() {
        return film;
    }

    public String getDate() {

        return date;
    }

    public String getTime() {

        return time;
    }

    public String getSeat() {

        return seat;
    }

    public String getIdNumber() {

        return idNumber;
    }

    public String getUsername() {

        return username;
    }
}

