package com.module.payment;

import java.io.IOException;

import org.json.JSONObject;

import com.module.util.RazorpayUtil;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/payment-callback")
public class PaymentCallback extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
//        doPost(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String razorpayPaymentId = request.getParameter("razorpay_payment_id");
        String razorpayOrderId = request.getParameter("razorpay_order_id");
        String razorpaySignature = request.getParameter("razorpay_signature");


        
        try {
        	JSONObject options = new JSONObject();
            options.put("razorpay_order_id", razorpayOrderId);
            options.put("razorpay_payment_id", razorpayPaymentId);
            options.put("razorpay_signature", razorpaySignature);
            
            boolean isValid = Utils.verifyPaymentSignature(options, RazorpayUtil.getRazorpayKeySecret());

			if (isValid) {
				// Signature verification successful
				response.setStatus(HttpServletResponse.SC_OK);
				response.sendRedirect("success.jsp?orderId=" + razorpayOrderId);
			} else {
				// Signature verification failed
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.sendRedirect("failure.jsp");
			}
         }catch (RazorpayException e) {
             // Signature verification failed
             System.out.println("RazorPay exception during callback: " + e.getMessage());
             e.printStackTrace();
         } catch (Exception e) {
             // Signature verification failed
        	 System.out.println("General exception during callback: " + e.getMessage());
             e.printStackTrace();
         }
        
	}

}
