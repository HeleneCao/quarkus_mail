package fr.rootar.servives;


import fr.rootar.Validator;
import fr.rootar.dto.MailDto;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/mail")
public class MailService {

    @Inject
    Mailer mailer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response sendEmail(MailDto mail) {
        /*if(!Validator.isValidMail(mail.getTo()))
            return Response.ok("Adresse mail non valide").status(400).build();*/

        mailer.send(
                Mail.withText(mail.getTo(),
                        mail.getSubject(),
                        mail.getText())
        );
        return Response.ok(mailer).build();
    }

    @GET
    @Path("/imperative")
    public void sendASimpleEmail() {
        mailer.send(Mail.withText("kamel.lcp@gmail.com", "A simple email from quarkus", "This is my body"));
    }
}
