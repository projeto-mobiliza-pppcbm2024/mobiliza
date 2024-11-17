package dev.bcgcompany.mobiliza.services;

import dev.bcgcompany.mobiliza.dtos.LeaseRequestDTO;
import dev.bcgcompany.mobiliza.entities.Cars;
import dev.bcgcompany.mobiliza.entities.Lease;
import dev.bcgcompany.mobiliza.entities.Payment;
import dev.bcgcompany.mobiliza.repositories.CarRepository;
import dev.bcgcompany.mobiliza.repositories.LeaseRepository;
import dev.bcgcompany.mobiliza.repositories.PaymentRepository;
import dev.bcgcompany.mobiliza.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaseService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LeaseRepository leaseRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public void processLease(Long userId, LeaseRequestDTO leaseRequestDTO) {
        var user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cars car = carRepository.findById(leaseRequestDTO.car_id())
                .orElseThrow(() -> new RuntimeException("Car not found"));

        Lease lease = new Lease();
        lease.setCars(car);
        lease.setUsers(user);
        lease.setInitial_date(leaseRequestDTO.start_date());
        lease.setFinal_date(leaseRequestDTO.final_date());
        leaseRepository.save(lease);

        var paymentDetails = leaseRequestDTO.payment_details();
        Payment payment = new Payment();
        payment.setLease(lease);
        payment.setAmount(paymentDetails.installments() * paymentDetails.installment_value());
        payment.setPaymentDate(paymentDetails.payment_date());
        payment.setPaymentMethod(paymentDetails.payment_method());
        paymentRepository.save(payment);
    }
}
