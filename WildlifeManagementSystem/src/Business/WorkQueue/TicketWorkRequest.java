/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class TicketWorkRequest extends WorkRequest{
    
    private String comments;

    public String getComment() {
        return comments;
    }

    public void setComment(String comments) {
        this.comments = comments;
    }
    
    
}
