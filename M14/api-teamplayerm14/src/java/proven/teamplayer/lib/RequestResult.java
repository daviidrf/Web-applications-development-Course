/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proven.teamplayer.lib;

/**
 *
 * @author alumne
 */
public class RequestResult {
    /**
     * data to be sent.
     */
    private Object data;
    /**
     * result code to be sent.
     */
    private int resultCode;

    public RequestResult(Object data, int resultCode) {
        this.data = data;
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FriendRequestResult{")
          .append("data="); sb.append(data)
          .append("resultCode=").append(resultCode)
          .append("}");
        return sb.toString();
    }
}
