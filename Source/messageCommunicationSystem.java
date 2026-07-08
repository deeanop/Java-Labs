interface Transmitter{
    public void store(Message message);
    public Message retrieve(Person receiver);
}
class Person{
    private final String name;
    private final String place;
    private Transmitter transmitter; 
    public Person(String name, String place){
        this.name = name;
        this.place = place;
    }
    public void setTransmitter(Transmitter transmitter){
        this.transmitter = transmitter;
    }
    public void send(Person person, String message){
        Message messageToSend = new Message(this, person, message);
        this.transmitter.store(messageToSend);
    }
    public void receiveNotification(Transmitter transmitter){
        Message message = transmitter.retrieve(this);
        if(message != null){
            System.out.println(message);
        }
    }
    @Override
    public String toString(){
        return "Name: " + this.name + ", place: " + this.place;
    }
    public Transmitter getTransmitter(){
        return this.transmitter;
    }
}
class Message{
    private final Person sender;
    private final Person receiver;
    private final String message;
    public Message(Person sender, Person receiver, String message){
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }
    @Override
    public String toString(){
        return "Sender: " + this.sender.toString() + ", receiver: " + this.receiver.toString() + ", transmitter type: " + this.sender.getTransmitter() + ", message: " + this.message;
    }
    public String getMessage(){
        return this.message;
    }
    public Person getReceiver(){
        return this.receiver;
    }
}
class MailTransmitter implements Transmitter{
    private Message[] buffer;
    private int count = 0;
    public MailTransmitter(int size){
        buffer = new Message[size];
    }
    @Override
    public void store(Message message){
        buffer[count] = message;
        count++;
        if(count >= buffer.length){
            for(int i=0; i<count; i++){
                buffer[i].getReceiver().receiveNotification(this);
            }
            count = 0;
        }
    }
    @Override
    public Message retrieve(Person receiver){
        Message found = null;
        for(int i=0; i<buffer.length; i++){
            if(buffer[i] != null && buffer[i].getReceiver() == receiver){
                found = buffer[i];
                buffer[i] = null;
            }
        }
        return found;
    }
}
class EmailTransmitter implements Transmitter{
    private Message message;
    @Override
    public void store(Message m){
        message = m;
        message.getReceiver().receiveNotification(this);
}
    @Override
    public Message retrieve(Person receiver){
        Message found = null;
        if(this.message != null && this.message.getReceiver() == receiver){
            found = this.message;
            this.message = null;
        }
        return found;
    }
}
class Client{
    public static void main(String[] args) {
        Person p1 = new Person("Paul", "Timisoara");
        Person p2 = new Person("Andreea", "Timisoara");
        Person p3 = new Person("Ioana", "Timisoara");
        Person p4 = new Person("Gabriel", "Timisoara");

        Transmitter email = new EmailTransmitter();
        Transmitter mail = new MailTransmitter(2);

        p1.setTransmitter(email);
        p1.send(p2, "Scrie-i Ioanei sa-mi dea adresa ei de e-mail!");

        p2.setTransmitter(mail);
        p2.send(p3, "Paul zice sa-i trimiti adresa ta de e-mail");

        p4.setTransmitter(mail);
        p4.send(p1, "Ce mai faci?");

        p3.setTransmitter(email);
        p3.send(p1, "Adresa mea de e-mail este: ioana@yahoo.com");
    }
}