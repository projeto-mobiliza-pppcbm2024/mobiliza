package dev.bcgcompany.mobiliza.services;

import dev.bcgcompany.mobiliza.controllers.dto.LeaseRequestDTO;
import dev.bcgcompany.mobiliza.entities.Car;
import dev.bcgcompany.mobiliza.entities.Lease;
import dev.bcgcompany.mobiliza.entities.Payment;
import dev.bcgcompany.mobiliza.entities.Users;
import dev.bcgcompany.mobiliza.exceptions.EntidadeNaoEncontradaException;
import dev.bcgcompany.mobiliza.repositories.CarRepository;
import dev.bcgcompany.mobiliza.repositories.LeaseRepository;
import dev.bcgcompany.mobiliza.repositories.PaymentRepository;
import dev.bcgcompany.mobiliza.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeaseService {

    private final LeaseRepository leaseRepository;
    private final PaymentRepository paymentRepository;
    private final UsersRepository usersRepository;
    private final CarRepository carRepository;

    @Autowired
    public LeaseService(LeaseRepository leaseRepository, PaymentRepository paymentRepository, UsersRepository usersRepository, CarRepository carRepository) {
        this.leaseRepository = leaseRepository;
        this.paymentRepository = paymentRepository;
        this.usersRepository = usersRepository;
        this.carRepository = carRepository;
    }

    public void confirm(String userId, LeaseRequestDTO leaseRequestDTO) {
        Users user = usersRepository.findById(Long.valueOf(userId))
                        .orElseThrow(EntidadeNaoEncontradaException::new);
        Car car = carRepository.findById(leaseRequestDTO.carId())
                        .orElseThrow(EntidadeNaoEncontradaException::new);
        car.setRented(true);
        Lease lease = leaseRequestDTO.toLease(user, car);
        Payment payment = leaseRequestDTO.paymentDetails().toPayment();
        leaseRepository.save(lease);
        payment.setLease(lease);
        paymentRepository.save(payment);
    }
}
