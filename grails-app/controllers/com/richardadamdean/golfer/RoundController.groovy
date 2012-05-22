package com.richardadamdean.golfer

import org.springframework.dao.DataIntegrityViolationException

class RoundController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [roundInstanceList: Round.list(params), roundInstanceTotal: Round.count()]
    }

    def create() {
        [roundInstance: new Round(params)]
    }

    def save() {
        def roundInstance = new Round(params)
        if (!roundInstance.save(flush: true)) {
            render(view: "create", model: [roundInstance: roundInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'round.label', default: 'Round'), roundInstance.id])
        redirect(action: "show", id: roundInstance.id)
    }

    def show() {
        def roundInstance = Round.get(params.id)
        if (!roundInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'round.label', default: 'Round'), params.id])
            redirect(action: "list")
            return
        }

        [roundInstance: roundInstance]
    }

    def edit() {
        def roundInstance = Round.get(params.id)
        if (!roundInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'round.label', default: 'Round'), params.id])
            redirect(action: "list")
            return
        }

        [roundInstance: roundInstance]
    }

    def update() {
        def roundInstance = Round.get(params.id)
        if (!roundInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'round.label', default: 'Round'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (roundInstance.version > version) {
                roundInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'round.label', default: 'Round')] as Object[],
                          "Another user has updated this Round while you were editing")
                render(view: "edit", model: [roundInstance: roundInstance])
                return
            }
        }

        roundInstance.properties = params

        if (!roundInstance.save(flush: true)) {
            render(view: "edit", model: [roundInstance: roundInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'round.label', default: 'Round'), roundInstance.id])
        redirect(action: "show", id: roundInstance.id)
    }

    def delete() {
        def roundInstance = Round.get(params.id)
        if (!roundInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'round.label', default: 'Round'), params.id])
            redirect(action: "list")
            return
        }

        try {
            roundInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'round.label', default: 'Round'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'round.label', default: 'Round'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
