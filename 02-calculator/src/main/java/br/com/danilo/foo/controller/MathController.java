package br.com.danilo.foo.controller;

import br.com.danilo.foo.exception.UnsupportedMathGenerationException;
import br.com.danilo.foo.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.danilo.foo.converter.NumberConverter.convertToDouble;
import static br.com.danilo.foo.converter.NumberConverter.isNumeric;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathGenerationException("Please set numeric value");
        }
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathGenerationException("Please set numeric value");
        }
        Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return math.sub(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathGenerationException("Please set numeric value");
        }
        return math.mult(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathGenerationException("Please set numeric value");
        }
        if (numberTwo.equals("0")) {
            throw new UnsupportedMathGenerationException("Second value cannot be zero");
        }
        return math.div(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/square/{numberOne}", method = RequestMethod.GET)
    public Double square(@PathVariable("numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathGenerationException("Please set numeric value");
        }
        return math.square(convertToDouble(numberOne));
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathGenerationException("Please set numeric value");
        }
        return math.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
    }
}
